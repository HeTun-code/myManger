package com.zzy.phone.service.impl;

import com.zzy.phone.service.AgendaService;

import com.zzy.pojo.Agenda;
import com.zzy.pojo.Notice;

import com.zzy.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AgendaServiceImpl implements AgendaService {
    @Autowired
    AgendaRepository agendaRepository = null;


    public Agenda getAgenda(Notice notice) {
        return agendaRepository.getAgendaByNotice(notice);
    }
}
