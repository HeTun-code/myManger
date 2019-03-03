package com.zzy.phone.service.impl;

import com.zzy.phone.service.NoticeService;
import com.zzy.pojo.Notice;
import com.zzy.pojo.User;
import com.zzy.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeRepository noticeRepository = null;
    public List<Notice> getNoticeByUserId(User user) {
        return noticeRepository.getNoticesByUsers(user);
    }
}
