package com.zzy.repository;

import com.zzy.pojo.Seat;
import com.zzy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SeatRepository extends CrudRepository<Seat,Integer>, PagingAndSortingRepository<Seat,Integer>, JpaRepository<Seat,Integer>, JpaSpecificationExecutor<Seat> {
    Seat findSeatByMeetingSeatId(Integer seat);
}
