package com.zzy.phone.vo;

import com.zzy.pojo.*;
import lombok.Data;

import java.util.List;

@Data
public class ReturnVo {
    private boolean state;
    private String msg;
    private List<Notice> notices;
    private Agenda agenda;
    private List<News> news;
    private Resource resources;
    private Seat seat;
    private User user;
    private Dept dept;
}
