package com.zzy.phone.controll;

import com.zzy.phone.service.ResourceService;
import com.zzy.phone.vo.ReturnVo;
import com.zzy.pojo.Resource;
import com.zzy.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("resource")
public class ResourceControll {
    @Autowired
    private ResourceService resourceService = null;

    @RequestMapping("getResource")
    public @ResponseBody
    ReturnVo getResource(@RequestBody Notice notice) {
        Resource resourceByUserId = resourceService.getResource(notice);
        ReturnVo returnVo = new ReturnVo();
        if (null != resourceByUserId) {
            returnVo.setResources(resourceByUserId);
            returnVo.setMsg("查找成功");
            returnVo.setState(true);
        }else {
            returnVo.setMsg("查找失败");
            returnVo.setState(false);
        }
        return returnVo;
    }

}
