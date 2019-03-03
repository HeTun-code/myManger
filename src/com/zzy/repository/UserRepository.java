package com.zzy.repository;

import com.zzy.pojo.Dept;
import com.zzy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

/**
 * @author 麋鹿君
 */
public interface UserRepository extends CrudRepository<User,Integer>, PagingAndSortingRepository<User,Integer>, JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    List<User> findAll();

    @Query(nativeQuery = true, value = "select * from t_user where userName=?1 and telNum=?2")
    List<User> getUsersByVo(String userName,String telNum);

    User getUserByUserLoginNameAndAndTelNum(String loginName, String telNum);

    User getUsersByUserId(Integer userId);

    User getUserByUserLoginNameAndAndTelNumAndPassword(String username, String telNum, String PSW);

    List<User> getUsersByDept(Dept dept);
}

