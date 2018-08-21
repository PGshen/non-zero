package space.zero.cron.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import space.zero.common.utils.ReflectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务示例
 * 在Application开启定时调度@EnableScheduling
 */
public class CronDemo {

    Logger logger = LoggerFactory.getLogger(CronDemo.class);

//    定时执行，固定时间点
    @Scheduled(cron = "0 0/1 * * * ?")
    public void taskTwo(){
        logger.info("Task two -- now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

//    等待前一次任务执行完成之后
//    fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
    @Scheduled(fixedDelay = 5000)
    public void testFixDelay() {
        logger.info("Task Three -- now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

//    不等待前一次方法执行完成
//    fixedRate = 5000表示当前方法开始执行5000ms后，Spring scheduling会再次调用该方法
    @Scheduled(fixedRate = 5000)
    public void testFixedRate() {
        logger.info("Task Four -- now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

//    第一次执行任务延迟时间
//    initialDelay = 1000表示延迟1000ms执行第一次任务
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void testInitialDelay() {
        logger.info("Task Five -- now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
