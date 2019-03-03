package com.zzy.repository;

import com.zzy.pojo.Agenda;
import com.zzy.pojo.Agenda;
import com.zzy.pojo.Notice;
import com.zzy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AgendaRepository extends CrudRepository<Agenda,Integer>, PagingAndSortingRepository<Agenda,Integer>, JpaRepository<Agenda,Integer>, JpaSpecificationExecutor<Agenda> {
    Agenda getAgendaByNotice(Notice notice);
}
