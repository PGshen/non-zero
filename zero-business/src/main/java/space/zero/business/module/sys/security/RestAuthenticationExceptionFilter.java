package space.zero.business.module.sys.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by PG_shen
 * Date : 3/8/18
 * Time : 4:47 PM
 */
public class RestAuthenticationExceptionFilter extends GenericFilterBean {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public RestAuthenticationExceptionFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);

            logger.debug("Chain processed normally");
        } catch (Exception e) {
            throw e;
        }
    }

}
