package com.muhuan.Service.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muhuan.Service.mapper.CityMapper;
import com.muhuan.Service.pojo.basic.City;
import com.muhuan.Service.util.CurrentAQIByCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "city")
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public void updateCurAQI() throws Exception{
        Map<String ,Object> cityDataMap = CurrentAQIByCity.CurrentAQIByCity();
        List<City> cities = cityMapper.findAll();
        for (City city :cities){
            String curAQI = JSONUtils.toJSONString(cityDataMap.get(city.getCity()));
            city.setCurAQI(curAQI);
            city.setUpdateTime(new Date());
            cityMapper.updateCurAQI(city);
        }
    }
    @Cacheable(key = "'all'")
    public List<City> getAll()
    {
        return cityMapper.findAll();
    }

    @Cacheable(key = "#p0")
    public City get(Integer id)
    {
        return cityMapper.get(id);
    }

    @CacheEvict(allEntries=true)
    public void insert(City city)
    {
        cityMapper.save(city);
    }


    @CacheEvict(allEntries=true)
    public void delete(Integer id)
    {
        cityMapper.delete(id);
    }

    @Cacheable(key = "#p0+'-'+#p1")
    public PageInfo<City> getPage(int start, int size) {
        List<City> cityList = cityMapper.findAll();
        PageHelper.startPage(start,size,"id desc");
        PageInfo<City> pageInfo = new PageInfo<>(cityList);
        return pageInfo;
    }

    public City findCity(City city) {
        return cityMapper.findCity(city);
    }
    @Cacheable(key = "'rank'")
    public List<City> getRank() {
        return cityMapper.findRank();
    }
}
