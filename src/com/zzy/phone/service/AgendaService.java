package com.zzy.phone.service;

import com.zzy.pojo.Agenda;
import com.zzy.pojo.Notice;
import com.zzy.pojo.User;

import java.util.List;

public interface AgendaService {
    Agenda getAgenda(Notice notice);
}
