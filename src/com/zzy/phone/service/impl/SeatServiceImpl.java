package com.zzy.phone.service.impl;

import com.zzy.phone.service.NoticeService;
import com.zzy.phone.service.SeatService;
import com.zzy.pojo.Notice;
import com.zzy.pojo.Seat;
import com.zzy.pojo.User;
import com.zzy.repository.NoticeRepository;
import com.zzy.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatRepository seatRepository = null;


    public Seat getSeat(Integer seatId) {
        return seatRepository.findSeatByMeetingSeatId(seatId);
    }
}
