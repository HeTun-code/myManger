package com.zzy.phone.service;

import com.zzy.pojo.News;
import com.zzy.pojo.Notice;
import com.zzy.pojo.User;

import java.util.List;

public interface NewsService {
    List<News> getNews(Integer type);
}
