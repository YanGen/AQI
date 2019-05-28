package com.muhuan.Service.controller;

import com.muhuan.Service.pojo.basic.City;
import com.muhuan.Service.pojo.flow.SearchParam;
import com.muhuan.Service.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author young
 * @ClassName: CityController
 * @Description: TODO()
 * @date 2019/3/2 0:06
 */
@RestController
@RequestMapping("/city")
@CrossOrigin("*")
public class CityController {
    private Map<String ,Object> dataMap = new HashMap<>();
    @Autowired
    CityService cityService;
    @RequestMapping("/all")
    public Map<String, Object> all(Model m) throws Exception{
        dataMap.put("success",true);
        List<City> cityList = cityService.getAll();
        dataMap.put("data",cityList);
        return dataMap;
    }
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public Map<String, Object> info(@RequestBody SearchParam searchParam){
        dataMap.put("success",true);
        dataMap.put("massage","成功!");

        String cityName = searchParam.getCityName();
        City city = new City();
        city.setCity(cityName);
        City res = cityService.findCity(city);
        dataMap.put("data",res);
        return dataMap;
    }
    @RequestMapping(value = "/rank")
    public Map<String, Object> rank(Model m) throws Exception{
        dataMap.put("success",true);
        List<City> cityList = cityService.getRank();
        dataMap.put("data",cityList);
        return dataMap;
    }

}
