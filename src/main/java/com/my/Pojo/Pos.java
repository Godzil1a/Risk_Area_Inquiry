package com.my.Pojo;

import java.util.List;

public class Pos {

    String area_name;
    String city;
    String county;
    String province;
    String type;
    List<String> communitys;

    @Override
    public String toString() {
        return "Pos{" +
                "area_name='" + area_name + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", province='" + province + '\'' +
                ", type='" + type + '\'' +
                ", communitys=" + communitys +
                '}';
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getCommunitys() {
        return communitys;
    }

    public void setCommunitys(List<String> communitys) {
        this.communitys = communitys;
    }
}
