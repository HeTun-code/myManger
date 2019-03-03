package com.zzy.repository;

import com.zzy.pojo.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


/**
 * @author 麋鹿君
 */
public interface MissionRepository extends CrudRepository<Mission,Integer>, PagingAndSortingRepository<Mission,Integer>, JpaRepository<Mission,Integer>, JpaSpecificationExecutor<Mission> {
    Mission getMissionByMissionId(Integer id);

    List<Mission> findAll();

}

