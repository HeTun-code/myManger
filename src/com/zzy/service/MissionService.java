package com.zzy.service;

import com.zzy.pojo.Mission;
import com.zzy.pojo.User;

import java.util.List;

/**
 * @author 麋鹿君
 */
public interface MissionService {

    Mission getMissionById(Integer id);
    List<Mission> getMissionAll();

    void delMissionById(Integer id);

    void upDataMissions(Mission missions);
}
