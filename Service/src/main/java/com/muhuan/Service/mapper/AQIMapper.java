package com.muhuan.Service.mapper;

import com.muhuan.Service.pojo.data.DataItem;
import com.muhuan.Service.pojo.basic.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface AQIMapper {

    @Select("select * from history_aqi_day_bound_city where city= #{id} order by id asc")
    List<DataItem> findDayBoundCity(City city);
    @Select("select * from history_aqi_month_bound_city where city= #{id} order by id asc")
    List<DataItem> findMonthBoundCity(City city);
    @Select("select * from future_aqi_month_bound_city where city= #{id} order by id asc")
    List<DataItem> findFutureMonthBoundCity(City city);
    @Select("select * from history_aqi_day_bound_day where id= #{city.id} and  start BETWEEN #{start} and #{end} order by id asc")
    List<DataItem> findDayBoundDay(@Param("city")City city, @Param("start") Date start, @Param("end")Date end);
    @Select("select * from history_aqi_day_bound_month where id= #{city.id} and  start BETWEEN #{start} and #{end} order by id asc")
    List<DataItem> findDayBoundMonth(@Param("city")City city, @Param("start") Date start, @Param("end")Date end);
    @Select("select * from compare_aqi_month_bound_city where city= #{id} order by id asc")
    List<DataItem> findCompareMonthBoundCity(City city);

//    @Insert("insert into basic_city ( name ) values (#{name}) ")
//    public int save(City city);
//
//    @Delete("delete from basic_city where id= #{id} ")
//    public void delete(int id);
//
//    @Select("select * from basic_city where id= #{id} ")
//    public City get(int id);

}
