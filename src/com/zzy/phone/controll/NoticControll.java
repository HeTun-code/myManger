package com.zzy.phone.controll;

import com.zzy.phone.service.NoticeService;
import com.zzy.phone.vo.ConstomNoticeVo;
import com.zzy.phone.vo.ConstomUserVo;
import com.zzy.phone.vo.ReturnVo;
import com.zzy.pojo.Notice;
import com.zzy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("notice")
public class NoticControll {
    @Autowired
    private NoticeService noticeService = null;

    @RequestMapping("getNotice")
    public @ResponseBody
    ReturnVo getNotice(@RequestBody User user) {
        System.out.println(user);
        List<Notice> noticeByUserId = noticeService.getNoticeByUserId(user);
        ReturnVo returnVo = new ReturnVo();
        if (null != noticeByUserId) {
            returnVo.setNotices(noticeByUserId);
            returnVo.setMsg("查找成功");
            returnVo.setState(true);
        }else {
            returnVo.setMsg("查找失败");
            returnVo.setState(false);
        }
        return returnVo;
    }

}
