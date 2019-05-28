package com.muhuan.Service.service;

import com.muhuan.Service.mapper.WeatherMapper;
import com.muhuan.Service.pojo.basic.City;
import com.muhuan.Service.pojo.data.DataItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
@CacheConfig(cacheNames = "weather")
public class WeatherService {
    @Autowired
    WeatherMapper weatherMapper;
    @Cacheable(key = "#p0.id+'-'+#p1")
    public List<DataItem> WeatherDayByCity(City city,String unit) {
        if(unit.equals("day")){
            return weatherMapper.findDayBoundCity(city);
        }else if (unit.equals("month")){
            return weatherMapper.findMonthBoundCity(city);
        }
        return null;
    }
    @Cacheable(key = "#p0.id+'-'+#p1+'-'+#p2+'-'+#p3")
    public List<DataItem> WeatherByDate(City city, String bound, String unit, Date start, Integer backward) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        List<DataItem> dataItemList = new LinkedList<>();
        if (unit.equals("day")){

            if (bound.equals("day")){

                c.add(Calendar.DAY_OF_MONTH, backward);
                Date end = c.getTime();
                dataItemList = weatherMapper.findDayBoundDay(city,start,end);
            }else if (bound.equals("month")){

                c.add(Calendar.MONTH, backward);
                Date end = c.getTime();
                dataItemList = weatherMapper.findDayBoundMonth(city,start,end);
            }
        }else if (unit.equals("hour")){
            if (bound.equals("day")){
                c.add(Calendar.DAY_OF_MONTH, backward);
                Date end = c.getTime();
                dataItemList = weatherMapper.findHourBoundDay(city,start,end);
            }
        }
        return dataItemList;
    }

    @Cacheable(key = "#p0.id")
    public List<DataItem> WeatherFutureMonthByCity(City city) {
        List<DataItem> dataItemList = weatherMapper.findFutureMonthBoundCity(city);

        return dataItemList;

    }
}
