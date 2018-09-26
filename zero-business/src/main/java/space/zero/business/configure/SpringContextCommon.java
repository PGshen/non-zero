package space.zero.business.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import space.zero.common.keyGenerator.KeyGenerator;
import space.zero.common.keyGenerator.TimeFormatKeyGenerator;
import space.zero.common.mail.MailSender;
import space.zero.cron.configure.ScheduleConfig;
import space.zero.cron.task.CronDemo;

/**
 * Created by PG_shen
 * Date : 3/14/18
 * Time : 8:23 PM
 * 该配置类主要用于将其他模块的引入Spring boot 扫描范围，从而注入到spring boot的bean管理中
 * 除普通bean外，配置类也可以引入
 */
@Configuration
public class SpringContextCommon {

    @Bean
    public KeyGenerator<String> stringKeyGenerator(){
        return new TimeFormatKeyGenerator();
    }

    @Bean
    public MailSender mailSender(){
        return new MailSender();
    }

//    @Bean
//    public CronDemo cronDemo(){
//        return new CronDemo();
//    }
//
//    @Bean
//    public ScheduleConfig scheduleConfig(){
//        return new ScheduleConfig();
//    }
}
