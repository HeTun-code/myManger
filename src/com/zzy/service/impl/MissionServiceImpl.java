package com.zzy.service.impl;

import com.zzy.pojo.Mission;
import com.zzy.pojo.User;
import com.zzy.repository.MissionRepository;
import com.zzy.repository.UserRepository;
import com.zzy.service.MissionService;
import com.zzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MissionServiceImpl implements MissionService {
    @Autowired
    MissionRepository missionRepository = null;

    public Mission getMissionById(Integer id) {
        return missionRepository.getMissionByMissionId(id);
    }

    public List<Mission> getMissionAll() {
        return missionRepository.findAll();
    }

    public void delMissionById(Integer id) {
        missionRepository.deleteById(id);
    }

    public void upDataMissions(Mission missions) {
        missionRepository.saveAndFlush(missions);
    }


}
