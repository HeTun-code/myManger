package com.zzy.phone.controll;

import com.zzy.phone.service.NewsService;
import com.zzy.phone.vo.ReturnVo;
import com.zzy.pojo.News;
import com.zzy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("news")
public class NewsControll {
    @Autowired
    private NewsService newsService = null;

    @RequestMapping("getNews")
    public @ResponseBody
    ReturnVo getNews(Integer type) {
        List<News> newsByType = newsService.getNews(type);
        ReturnVo returnVo = new ReturnVo();
        if (null != newsByType) {
            returnVo.setNews(newsByType);
            returnVo.setMsg("查找成功");
            returnVo.setState(true);
        }else {
            returnVo.setMsg("查找失败");
            returnVo.setState(false);
        }
        return returnVo;
    }

}
