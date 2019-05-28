package com.muhuan.Service.mapper;


import com.muhuan.Service.pojo.basic.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CityMapper {
    @Select("select * from basic_city order by id asc")
    @Results(id="cityMap",value = {
            @Result(property = "curAQI",column = "cur_aqi"),
            @Result(property = "updateTime",column = "upd_time"),
            @Result(property = "cityEng",column = "city_eng"),
            @Result(property = "cityNum",column = "city_num"),
            @Result(property = "searchId",column = "search_id"),
            @Result(property = "topCount",column = "top_count"),
    })
    List<City> findAll();

    @Insert("insert into basic_city ( name ) values (#{name}) ")
    public int save(City city);

    @Delete("delete from basic_city where id= #{id} ")
    public void delete(int id);

    @Select("select * from basic_city where id= #{id} ")
    @ResultMap(value = "cityMap") // 复用前面所写
    public City get(int id);

    @Update("update basic_city set cur_aqi=#{curAQI},upd_time=#{updateTime} where id=#{id} ")
    public int updateCurAQI(City city);
    @Select("select * from basic_city where city= #{city}")
    @ResultMap(value = "cityMap")
    City findCity(City city);
    @Select("select * from basic_city where rank > -1 order by rank asc")
    @ResultMap(value = "cityMap")
    List<City> findRank();
}
