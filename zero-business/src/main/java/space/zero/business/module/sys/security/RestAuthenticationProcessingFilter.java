package space.zero.business.module.sys.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.Assert;
import space.zero.common.jsonLib.mapper.JsonMapper;
import space.zero.common.utils.MIMEType;
import space.zero.common.utils.StringUtils;
import space.zero.core.result.ResultGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * rest api filter，content type 只能是application/json，multipart/form-data。前者返回json数据，后者主要用于文件传输
 *
 * Created by jiabinl on 2017-3-10.
 */
public class RestAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {


    public static  final String DEFAULT_PARAMKEY_USERNAME="username";

    public static  final String DEFAULT_PARAMKEY_PASSWORD="password";

    private String usernameParameter = DEFAULT_PARAMKEY_USERNAME;
    private String passwordParameter = DEFAULT_PARAMKEY_PASSWORD;


    /**
     * 拦截login
     * 认证成功记失败处理，类型为json
     */
    public RestAuthenticationProcessingFilter(){
        // rest api 请求登陆拦截
        super(new ContentTypeAntPathRequestMatcher("/login","POST",MIMEType.APPLICATION_JSON));
        // 设置登陆成功处理方法
        setAuthenticationSuccessHandler(new SysAuthenticationSuccessHandler());
        // 设置登陆成功处理方法
        setAuthenticationFailureHandler(new SysAuthenticationFailureHandler());
    }

    /**
     * 鉴权函数
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        System.out.println("---------------- rest api authentication ---------------------");

        String contentType = request.getContentType();
        System.out.println(contentType);

        if(contentType != null
                && (contentType.contains(MIMEType.APPLICATION_JSON) || contentType.contains(MIMEType.MULTIPART_FORM_DATA))
                && "POST".equalsIgnoreCase(request.getMethod())){

            String data = StringUtils.readStringFormInputStream(request.getInputStream());
            Map<String, Object> dataMap = JsonMapper.getInstance().readValue(data);
            String username = (String) dataMap.get(getUsernameParameter());
            String password = (String) dataMap.get(getPasswordParameter());

            logger.debug(username+"try to login and get token from restful interface");

            if (username == null) {
                username = "";
            }

            if (password == null) {
                password = "";
            }

            username = username.trim();

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                    username, password);

            // Allow subclasses to set the "details" property
            setDetails(request, authRequest);

            return this.getAuthenticationManager().authenticate(authRequest);

        }
        return null;
    }

    /**
     * Provided so that subclasses may configure what is put into the authentication
     * request's details property.
     *
     * @param request that an authentication request is being created for
     * @param authRequest the authentication request object that should have its details
     * set
     */
    protected void setDetails(HttpServletRequest request,
                              UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }


    /**
     * Sets the parameter name which will be used to obtain the username from the login
     * request.
     *
     * @param usernameParameter the parameter name. Defaults to "username".
     */
    public void setUsernameParameter(String usernameParameter) {
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.usernameParameter = usernameParameter;
    }

    /**
     * Sets the parameter name which will be used to obtain the password from the login
     * request..
     *
     * @param passwordParameter the parameter name. Defaults to "password".
     */
    public void setPasswordParameter(String passwordParameter) {
        Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
        this.passwordParameter = passwordParameter;
    }


    public final String getUsernameParameter() {
        return usernameParameter;
    }

    public final String getPasswordParameter() {
        return passwordParameter;
    }

}

