package space.zero.business.configure;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * Created by PG_shen
 * Date : 3/9/18
 * Time : 10:25 AM
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=1800,redisNamespace="fire-safety")
public class SpringContextSpringSession implements EnvironmentAware {

    private Environment env;

    @Bean
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        HeaderHttpSessionStrategy headerHttpSessionStrategy = new HeaderHttpSessionStrategy(); // <3>
        headerHttpSessionStrategy.setHeaderName(env.getProperty("app.session.headerTokenName"));
        return headerHttpSessionStrategy;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env=environment;
    }
}
