package com.muhuan.Service.pojo.basic;

import com.gitee.sunchenbin.mybatis.actable.annotation.Table;

import java.io.Serializable;
import java.util.Date;

@Table(name = "basic_city")
public class City implements Serializable {
    private Integer id;
    private String city;
    private String location;
    private String curAQI;
    private Date updateTime;
    private String cityEng;
    private String cityNum;
    private String searchId;
    private Integer topCount;
    private Integer rank;

    @Override
    public String   toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", location='" + location + '\'' +
                ", curAQI='" + curAQI + '\'' +
                ", updateTime=" + updateTime +
                ", cityEng='" + cityEng + '\'' +
                ", cityNum='" + cityNum + '\'' +
                ", searchId='" + searchId + '\'' +
                ", topCount=" + topCount +
                ", rank=" + rank +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCurAQI() {
        return curAQI;
    }

    public void setCurAQI(String curAQI) {
        this.curAQI = curAQI;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCityEng() {
        return cityEng;
    }

    public void setCityEng(String cityEng) {
        this.cityEng = cityEng;
    }

    public String getCityNum() {
        return cityNum;
    }

    public void setCityNum(String cityNum) {
        this.cityNum = cityNum;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public Integer getTopCount() {
        return topCount;
    }

    public void setTopCount(Integer topCount) {
        this.topCount = topCount;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
