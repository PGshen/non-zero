package space.zero.business.configure;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by PG_shen
 * Date : 3/8/18
 * Time : 5:06 PM
 * 主要用于在没有使用spring-mvc情况下，注册过滤器，传递SecurityConfig类到父类中，确保配置信息被加在
 */
public class ZeroSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    /**
     * 传递SecurityConfig类到父类中
     */
    public ZeroSecurityInitializer() {
        super(SpringContextSecurity.class);
    }
}
