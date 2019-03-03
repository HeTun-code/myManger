package com.zzy.repository;

import com.zzy.pojo.Resource;
import com.zzy.pojo.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResourceRepository extends CrudRepository<Resource,Integer>, PagingAndSortingRepository<Resource,Integer>, JpaRepository<Resource,Integer>, JpaSpecificationExecutor<Resource> {
    Resource getResourceByMeetingNotice(Notice notice);
}
