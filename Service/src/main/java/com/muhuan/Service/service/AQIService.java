package com.muhuan.Service.service;

import com.muhuan.Service.mapper.AQIMapper;
import com.muhuan.Service.pojo.data.DataItem;
import com.muhuan.Service.pojo.basic.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
@CacheConfig(cacheNames = "aqi")
public class AQIService {
    @Autowired
    private AQIMapper aqiMapper;

    @Cacheable(key = "#p0.id+'-'+#p1")
    public List<DataItem> AQIDayByCity(City city,String unit){
        if (unit.equals("day")){
            return aqiMapper.findDayBoundCity(city);
        }else if(unit.equals("month")) {
            return aqiMapper.findMonthBoundCity(city);
        }
        return null;
    }

    @Cacheable(key = "#p0.id-#p1-#p2-#p3")
    public List<DataItem> AQIDayByDate(City city, String bound,String unit, Date start, Integer backward) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        List<DataItem> dataItemList = new LinkedList<>();
        if(unit.equals("day")){

            if (bound.equals("day")){

                c.add(Calendar.DAY_OF_MONTH, backward);
                Date end = c.getTime();
                dataItemList = aqiMapper.findDayBoundDay(city,start,end);
            }else if (bound.equals("month")){

                c.add(Calendar.MONTH, backward);
                Date end = c.getTime();
                dataItemList = aqiMapper.findDayBoundMonth(city,start,end);
            }

        }else if (unit.equals("hour")){
            if (bound.equals("day")){
//                c.add(Calendar.DAY_OF_MONTH, backward);
//                Date end = c.getTime();
//                dataItemList = aqiMapper.findHourBoundDay(city,start,end);
            } else if (bound.equals("city")) {

            }
        }
        return dataItemList;
    }

    public List<DataItem> AQIFutureMonthBoundCity(City city) {
        List<DataItem> dataItemList = aqiMapper.findFutureMonthBoundCity(city);
        return dataItemList;
    }
    @Cacheable(key = "#p0.id")
    public List<DataItem> AQICompareMonthByCity(City city) {
        List<DataItem> dataItemList = aqiMapper.findCompareMonthBoundCity(city);
        return dataItemList;
    }
}
