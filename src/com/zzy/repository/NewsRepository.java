package com.zzy.repository;

import com.zzy.pojo.News;
import com.zzy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface NewsRepository extends CrudRepository<News,Integer>, PagingAndSortingRepository<News,Integer>, JpaRepository<News,Integer>, JpaSpecificationExecutor<News> {
    List<News> getNewsByType(Integer type);
}
