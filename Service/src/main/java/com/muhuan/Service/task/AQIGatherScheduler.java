package com.muhuan.Service.task;

import com.muhuan.Service.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class AQIGatherScheduler {
    private static final Logger logger = LoggerFactory.getLogger(AQIGatherScheduler.class);

    @Autowired
    CityService cityService;

    @Scheduled(cron = "0 0/60 * * * ?")
    public void executeUpdateCityAQI(){
        // 间隔60分钟,刷新三百个城市
        try {
            cityService.updateCurAQI();
        }catch (Exception e){
            System.out.println("错误！");
            System.out.println(e.getMessage());
        }finally {
            logger.info(" 定时任务:更新各城市当前AQI 速度:365个/60分钟");
        }
    }
}
