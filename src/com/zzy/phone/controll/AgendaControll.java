package com.zzy.phone.controll;

import com.zzy.phone.service.AgendaService;
import com.zzy.phone.vo.ReturnVo;
import com.zzy.pojo.Agenda;
import com.zzy.pojo.Notice;
import com.zzy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("agenda")
public class AgendaControll {
    @Autowired
    private AgendaService agendaService = null;

    @RequestMapping("getAgenda")
    public @ResponseBody
    ReturnVo getAgenda(@RequestBody Notice notice) {
        System.out.println(notice);
        Agenda agendaByUserId = agendaService.getAgenda(notice);
        System.out.println(agendaByUserId);
        ReturnVo returnVo = new ReturnVo();
        if (null != agendaByUserId) {
            returnVo.setAgenda(agendaByUserId);
            returnVo.setMsg("查找成功");
            System.out.println("test");
            returnVo.setState(true);
        }else {
            returnVo.setMsg("查找失败");
            returnVo.setState(false);
        }
        return returnVo;
    }

}
