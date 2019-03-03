package com.zzy.phone.service.impl;

import com.zzy.phone.service.NewsService;
import com.zzy.phone.service.NoticeService;
import com.zzy.pojo.News;
import com.zzy.pojo.Notice;
import com.zzy.pojo.User;
import com.zzy.repository.NewsRepository;
import com.zzy.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository = null;

    public List<News> getNews(Integer type) {
        return newsRepository.getNewsByType(type);
    }
}
