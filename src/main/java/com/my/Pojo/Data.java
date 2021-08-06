package com.my.Pojo;

import java.util.List;

public class Data {

    String end_update_time;
    Integer hcount;
    Integer mcount;
    List<Pos> highlist;
    List<Pos> middlelist;

    public String getEnd_update_time() {
        return end_update_time;
    }

    public void setEnd_update_time(String end_update_time) {
        this.end_update_time = end_update_time;
    }

    public Integer getHcount() {
        return hcount;
    }

    public void setHcount(Integer hcount) {
        this.hcount = hcount;
    }

    public Integer getMcount() {
        return mcount;
    }

    public void setMcount(Integer mcount) {
        this.mcount = mcount;
    }

    public List<Pos> getHighlist() {
        return highlist;
    }

    public void setHighlist(List<Pos> highlist) {
        this.highlist = highlist;
    }

    public List<Pos> getMiddlelist() {
        return middlelist;
    }

    public void setMiddlelist(List<Pos> middlelist) {
        this.middlelist = middlelist;
    }

    @Override
    public String toString() {
        return "Data{" +
                "end_update_time='" + end_update_time + '\'' +
                ", hcount=" + hcount +
                ", mcount=" + mcount +
                ", highlist=" + highlist +
                ", middlelist=" + middlelist +
                '}';
    }
}
