package com.muhuan.Service.controller;

import com.muhuan.Service.pojo.data.DataItem;
import com.muhuan.Service.pojo.basic.City;
import com.muhuan.Service.pojo.flow.SearchParam;
import com.muhuan.Service.service.AQIService;
import com.muhuan.Service.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/aqi")
@CrossOrigin("*")
public class AQIController {

    private Map<String ,Object> dataMap = new HashMap<>();
    @Autowired
    CityService cityService;
    @Autowired
    AQIService aqiService;
    /**
     * @Param unit :单位，只能是hour day month
     * @Param bound :绑定，只能是 city , day month year
     * @Param Start : 开始时间
     * @Param end :结束时间 提交不用给
     * @Param backward : 向后走几步
     */
    @RequestMapping(value = "/aqiData",method = RequestMethod.POST)
    public Map<String, Object> aqiData(@RequestBody SearchParam searchParam){
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
            List<DataItem> dataItemData = aqiService.AQIDayByCity(city,unit);
            dataMap.put("data", dataItemData);
        }else if (bound.equals("month") || bound.equals("year")||bound.equals("day")){
            List<DataItem> aqiDayBoundDate = aqiService.AQIDayByDate(city,bound,unit,start,backward);
            dataMap.put("data",aqiDayBoundDate);
        }


        return dataMap;
    }

    @RequestMapping(value = "/aqiFutureData",method = RequestMethod.POST)
    public Map<String, Object> aqiFutureData(@RequestBody SearchParam searchParam){
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
            List<DataItem> dataItemData = aqiService.AQIFutureMonthBoundCity(city);
            dataMap.put("data", dataItemData);
        }


        return dataMap;
    }

    @RequestMapping(value = "/aqiCompareData",method = RequestMethod.POST)
    public Map<String, Object> aqiCompareData(@RequestBody SearchParam searchParam){
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
            List<DataItem> dataItemData = aqiService.AQICompareMonthByCity(city);
            dataMap.put("data", dataItemData);
        }


        return dataMap;
    }

}
