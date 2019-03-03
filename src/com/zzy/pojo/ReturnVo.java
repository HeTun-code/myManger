package com.zzy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 麋鹿君
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReturnVo {
    private int msgState;
    private String msgType;
    private String msg;
    private Object obj;
}
