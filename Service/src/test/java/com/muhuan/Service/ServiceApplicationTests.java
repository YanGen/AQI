package com.muhuan.Service;

import com.muhuan.Service.mapper.CityMapper;
import com.muhuan.Service.mapper.StudentMapper;
import com.muhuan.Service.mapper.WeatherMapper;
import com.muhuan.Service.pojo.Student;
import com.muhuan.Service.pojo.basic.City;
import com.muhuan.Service.pojo.data.DataItem;
import com.muhuan.Service.service.CityService;
import com.muhuan.Service.task.AQIGatherScheduler;
import com.muhuan.Service.util.CurrentAQIByCity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceApplicationTests {

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private CityService cityService;
	@Autowired
	private WeatherMapper weatherMapper;
	@Test
	public void cityTest(){

		try {

			cityService.updateCurAQI();

		}catch (Exception e){
			System.out.println(e.getMessage());
		}

//		City city = new City();
//		city.setId(182);
//		city.setCity("兴安盟");
//
//		Date end = new Date();
//		Calendar c = Calendar.getInstance();
//		c.setTime(end);
//		c.add(Calendar.DAY_OF_MONTH, -90);
//		Date start = c.getTime();
//
//		List<DataItem> dataItems = weatherMapper.findHourBoundDay(city,start,end);
//		for(DataItem dataItem : dataItems){
//			System.out.println(dataItem.getStart());
//		}

//		try {
//
//			CurrentAQIByCity.CurrentAQIByCity();
//
//		}catch (Exception e){
//			System.out.println(e.getMessage());
//		}
	}

}
