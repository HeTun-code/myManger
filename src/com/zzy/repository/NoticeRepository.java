package com.zzy.repository;

import com.zzy.pojo.Notice;
import com.zzy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface NoticeRepository extends CrudRepository<Notice,Integer>, PagingAndSortingRepository<Notice,Integer>, JpaRepository<Notice,Integer>, JpaSpecificationExecutor<Notice> {
    List<Notice> getNoticesByUsers(User user);
}
