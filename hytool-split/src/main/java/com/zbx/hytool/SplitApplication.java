package com.zbx.hytool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class SplitApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SplitApplication.class);

        DBMapper bean = context.getBean(DBMapper.class);

        final LocalDateTime[] filter = {LocalDateTime.now()};

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                OrderInfo orderInfo = bean.selectTopOrder(filter[0]);
                if (orderInfo == null) {
                    System.out.println("未查询到订单");
                    return;
                }
                System.out.println(orderInfo);
                filter[0] = orderInfo.getEndTime();
            }
        }, 5000, 1000);
    }
}
