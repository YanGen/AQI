package com.muhuan.Service.mapper;

import com.muhuan.Service.pojo.basic.City;
import com.muhuan.Service.pojo.data.DataItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface WeatherMapper {
    @Select("select * from history_weather_day_bound_city where city= #{id} order by id asc")
    List<DataItem> findDayBoundCity(City city);
    @Select("select * from history_weather_month_bound_city where city= #{id} order by id asc")
    List<DataItem> findMonthBoundCity(City city);

    @Select("select * from history_aqi_day_bound_day where city= #{city.id} and  start BETWEEN #{start} and #{end} order by id asc")
    List<DataItem> findDayBoundDay(@Param("city")City city, @Param("start") Date start, @Param("end")Date end);
    @Select("select * from history_weather_day_bound_month where city= #{city.id} and  start BETWEEN #{start} and #{end} order by id asc")
    List<DataItem> findDayBoundMonth(@Param("city")City city, @Param("start") Date start, @Param("end")Date end);
    @Select("select * from history_weather_hour_bound_day where city= #{city.id} and  start BETWEEN #{start} and #{end} order by id asc")
    List<DataItem> findHourBoundDay(@Param("city")City city, @Param("start") Date start, @Param("end")Date end);

    @Select("select * from future_weather_month_bound_city where city= #{id} order by id asc")
    List<DataItem> findFutureMonthBoundCity(City city);
}
