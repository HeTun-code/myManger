package com.zzy.phone.vo;

import com.zzy.pojo.User;
import lombok.Data;


/**
 * @author 麋鹿君
 */
@Data
public class ConstomUserVo extends User{
    private boolean state;
    private String msg;
}
