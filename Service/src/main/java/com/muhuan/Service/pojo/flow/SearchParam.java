package com.muhuan.Service.pojo.flow;

import java.io.Serializable;
import java.util.Date;

public class SearchParam implements Serializable {
    private Integer cityId = 0;
    private String cityName;
    private String unit = "day";
    private String bound = "city";
    private Date start;
    private Date end;
    private Integer backward = 3;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBound() {
        return bound;
    }

    public void setBound(String bound) {
        this.bound = bound;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getBackward() {
        return backward;
    }

    public void setBackward(Integer backward) {
        this.backward = backward;
    }

    @Override
    public String toString() {
        return "SearchParam{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", unit='" + unit + '\'' +
                ", bound='" + bound + '\'' +
                ", start=" + start +
                ", end='" + end + '\'' +
                ", backward=" + backward +
                '}';
    }
}
