package com.zzy.phone.controll;

import com.zzy.phone.service.NoticeService;
import com.zzy.phone.service.SeatService;
import com.zzy.phone.vo.ReturnVo;
import com.zzy.pojo.Seat;

import com.zzy.pojo.User;
import com.zzy.service.UserService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("seat")
public class SeatControll {
    @Autowired
    private SeatService seatService = null;
    @Autowired
    private UserService userService = null;
    @Autowired
    private NoticeService noticeService = null;

    @RequestMapping("getSeat")
    public @ResponseBody
    ReturnVo getSeat(Integer setaid) {
        Seat seatByType = seatService.getSeat(setaid);

        ReturnVo returnVo = new ReturnVo();
        if (null != seatByType) {
            returnVo.setSeat(seatByType);
            returnVo.setMsg("查找成功");
            returnVo.setState(true);
        }else {
            returnVo.setMsg("查找失败");
            returnVo.setState(false);
        }
        return returnVo;
    }

}
