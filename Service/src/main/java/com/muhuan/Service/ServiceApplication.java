package com.muhuan.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
//允许定时任务
@EnableScheduling
public class ServiceApplication {


	public static void main(String[] args) {

		System.setProperty("spring.devtools.restart.enabled", "true");
		SpringApplication.run(ServiceApplication.class, args);
	}

}
