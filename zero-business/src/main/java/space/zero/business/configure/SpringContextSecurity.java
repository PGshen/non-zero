package space.zero.business.configure;

/**
 * Created by PG_shen
 * Date : 3/8/18
 * Time : 5:00 PM
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import space.zero.business.module.sys.security.*;
import space.zero.business.module.sys.service.SysUserService;

/**
 * spring-security配置
 */
@Configuration
@EnableWebSecurity()
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringContextSecurity extends WebSecurityConfigurerAdapter implements EnvironmentAware {

    private Environment env;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private  AuthenticationManager authenticationManager;

    /**
     * 身份验证配置，用于注入自定义身份验证Bean和密码校验规则
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysUserService);
    }

    /**
     * Request层面的配置，对应XML Configuration中的<http>元素
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterBefore(restAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterAt(defaultAuthenticationProcessingFilter(),UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(restAuthenticationExceptionFilter(), ExceptionTranslationFilter.class)
                .cors()
                .and().authorizeRequests()
                .mvcMatchers("/favicon.ico", "/wechat/portal","/act/**","/modeler/**","/diagram-viewer/**","/wechat/login","/wechat/loginPage","/msg/**","/wechat/oauth","/web/**")
//                .mvcMatchers("/**")
                .permitAll()
                .and().authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().formLogin()
                .permitAll()
                .loginPage("/index.html")
                .defaultSuccessUrl("/swagger-ui.html")
                .failureUrl("/index.html")
                .and().logout()
                .permitAll()
                .and().httpBasic();
    }

    /**
     * Web层面的配置，一般用来配置无需安全检查的路径
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/images/**","/js/**", "/static/**");
    }

    /**
     * restful 登陆接口过滤器
     * @return
     */
    @Bean
    public RestAuthenticationProcessingFilter restAuthenticationProcessingFilter(){

        RestAuthenticationProcessingFilter restAuthenticationProcessingFilter = new RestAuthenticationProcessingFilter();
        restAuthenticationProcessingFilter.setAuthenticationManager(authenticationManager);
        return restAuthenticationProcessingFilter;
    }

    /**
     * 网站登陆接口过滤器
     * @return
     */
    @Bean
    public DefaultAuthenticationProcessingFilter defaultAuthenticationProcessingFilter(){

        DefaultAuthenticationProcessingFilter defaultAuthenticationProcessingFilter = new DefaultAuthenticationProcessingFilter(new AntPathRequestMatcher("/login","POST"));
        defaultAuthenticationProcessingFilter.setAuthenticationManager(authenticationManager);
        return defaultAuthenticationProcessingFilter;
    }

    /**
     * rest 接口权限异常返回过滤器
     * @return
     */
    @Bean
    public RestAuthenticationExceptionFilter restAuthenticationExceptionFilter(){
        return new RestAuthenticationExceptionFilter();
    }

    /**
     * 密码加密器
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 安全元数据源
     * @return
     */
    @Bean
    public SysSecurityMetadataSource newSysSecurityMetadataSource() {
        return new SysSecurityMetadataSource();
    }

    /**
     * 提供访问决策
     * @return
     */
    @Bean
    public SysAccessDecisionManager newSysAccessDecisionManager() {
        return new SysAccessDecisionManager();
    }

    /**
     * 通过决策管理器、认证管理器、安全元数据来判断用户是否能够访问资源
     * @return
     */
    @Bean
    public SysSecurityFilter newSysSecurityFilter() {
        SysSecurityFilter sysSecurityFilter = new SysSecurityFilter(newSysSecurityMetadataSource());
        sysSecurityFilter.setAccessDecisionManager(newSysAccessDecisionManager());
        return sysSecurityFilter;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env=environment;
    }
}

