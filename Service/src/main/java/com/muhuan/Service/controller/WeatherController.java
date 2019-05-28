package com.muhuan.Service.controller;

import com.muhuan.Service.pojo.basic.City;
import com.muhuan.Service.pojo.data.DataItem;
import com.muhuan.Service.pojo.flow.SearchParam;
import com.muhuan.Service.service.CityService;
import com.muhuan.Service.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/weather")
@CrossOrigin("*")
public class WeatherController {
    private Map<String ,Object> dataMap = new HashMap<>();
    @Autowired
    CityService cityService;
    @Autowired
    WeatherService weatherService;
    /**
     * @Param unit :单位，只能是hour day month
     * @Param bound :绑定，只能是 city , day month year
     * @Param Start : 开始时间
     * @Param end :结束时间 提交不用给
     * @Param backward : 向后走几步
     */
    @RequestMapping(value = "/weatherData",method = RequestMethod.POST)
    public Map<String, Object> weatherData(@RequestBody SearchParam searchParam){
        dataMap.put("success",true);
        dataMap.put("massage","成功!");

        Integer cityId = searchParam.getCityId();
        String cityName = searchParam.getCityName();
        String unit = searchParam.getUnit();
        String bound = searchParam.getBound();
        Date start = searchParam.getStart();
        Integer backward = searchParam.getBackward();

        System.out.println(searchParam.toString());

        if(cityId == null || cityName==null){
            dataMap.put("success",false);
            dataMap.put("massage","参数不合法!");
            return dataMap;
        }

        City city = new City();
        city.setId(cityId);
        city.setCity(cityName);

        if (bound.equals("city")){
            List<DataItem> dataItemData = weatherService.WeatherDayByCity(city,unit);
            dataMap.put("data", dataItemData);
        }else if (bound.equals("month") || bound.equals("year")||bound.equals("day")){
            List<DataItem> dataItemData = weatherService.WeatherByDate(city,bound,unit,start,backward);
            dataMap.put("data",dataItemData);
        }


        return dataMap;
    }
    /**
     * @Param unit :单位，只能是hour day month
     * @Param bound :绑定，只能是 city , day month year
     * @Param Start : 开始时间
     * @Param end :结束时间 提交不用给
     * @Param backward : 向后走几步
     */
    @RequestMapping(value = "/weatherFutureData",method = RequestMethod.POST)
    public Map<String, Object> weatherFutureData(@RequestBody SearchParam searchParam){
        dataMap.put("success",true);
        dataMap.put("massage","成功!");

        Integer cityId = searchParam.getCityId();
        String cityName = searchParam.getCityName();
        String unit = searchParam.getUnit();
        String bound = searchParam.getBound();
        Date start = searchParam.getStart();
        Integer backward = searchParam.getBackward();

        System.out.println(searchParam.toString());

        if(cityId == null || cityName==null){
            dataMap.put("success",false);
            dataMap.put("massage","参数不合法!");
            return dataMap;
        }

        City city = new City();
        city.setId(cityId);
        city.setCity(cityName);

        if (bound.equals("city")){
            List<DataItem> dataItemData = weatherService.WeatherFutureMonthByCity(city);
            dataMap.put("data", dataItemData);
        }


        return dataMap;
    }
}
