package com.zzy.phone.vo;

import com.zzy.pojo.Notice;
import lombok.Data;

@Data
public class ConstomNoticeVo extends Notice {
    private boolean state;
    private String msg;
}
