package space.zero.business.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import space.zero.common.keyGenerator.KeyGenerator;
import space.zero.common.keyGenerator.TimeFormatKeyGenerator;

/**
 * Created by PG_shen
 * Date : 3/14/18
 * Time : 8:23 PM
 */
@Configuration
public class SpringContextCommon {

    @Bean
    public KeyGenerator<String> stringKeyGenerator(){
        return new TimeFormatKeyGenerator();
    }
}
