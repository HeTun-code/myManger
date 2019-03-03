package com.zzy.phone.service.impl;

import com.zzy.phone.service.AgendaService;
import com.zzy.phone.service.ResourceService;
import com.zzy.pojo.Agenda;
import com.zzy.pojo.Notice;
import com.zzy.pojo.Resource;
import com.zzy.repository.AgendaRepository;
import com.zzy.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    ResourceRepository resourceRepository = null;


    public Resource getResource(Notice notice) {
        return resourceRepository.getResourceByMeetingNotice(notice);
    }
}
