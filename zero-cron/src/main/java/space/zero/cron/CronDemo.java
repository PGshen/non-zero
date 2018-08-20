package space.zero.cron;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CronDemo {
    @Scheduled(cron = "0 0/1 * * * ?")
    public void taskTwo(){
        System.out.println("Task two -- now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
