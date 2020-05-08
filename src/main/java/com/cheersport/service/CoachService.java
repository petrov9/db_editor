package com.cheersport.service;

import com.cheersport.dao.CoachDao;
import com.cheersport.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoachService {

    @Autowired
    private CoachDao coachDao;

    public void setCoachDao(CoachDao CoachDao) {
        this.coachDao = CoachDao;
    }

    @Transactional
    public  List<Coach> listCoach() {
        return coachDao.listCoach();

        }
    @Transactional
    public void addCoach(Coach c) {
        coachDao.addCoach(c);
    }

    @Transactional
    public void deleteCoach(int id) {
        coachDao.deleteCoach(id);
    }

    @Transactional
    public Coach getCoach(int id) {
        return coachDao.get(id);
    }
}
