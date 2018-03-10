package space.zero.business.configure;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by PG_shen
 * Date : 3/9/18
 * Time : 10:24 AM
 */
public class ZeroSessionInitializer extends AbstractHttpSessionApplicationInitializer {

    public ZeroSessionInitializer() {
        super(SpringContextSpringSession.class);
    }
}
