package com.zzy.phone.service;

import com.zzy.pojo.Notice;
import com.zzy.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NoticeService {
    List<Notice> getNoticeByUserId(User user);
}
