package com.cheersport.service;

import com.cheersport.dao.SportsmanDao;
import com.cheersport.model.Sportsman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportsmanService {

    @Autowired
    private SportsmanDao sportsmanDao;

    public void setSportsmanDao(SportsmanDao sportsmanDao) {
        this.sportsmanDao = sportsmanDao;
    }

    @Transactional
    public List<Sportsman> listSportsman() {
        return this.sportsmanDao.listSportsman();

        }
    @Transactional
    public void addSportsman(Sportsman s) {
        sportsmanDao.addSportsman(s);
    }

    @Transactional
    public void deleteSportsman(int id) {
        sportsmanDao.deleteSportsman(id);
    }

    @Transactional
    public Sportsman getSportsman(int id) {
        return sportsmanDao.get(id);
    }

    @Transactional
    public List<Sportsman> getSportsmanOrderByPlace() {
        return sportsmanDao.listSportsmanOrderByPlace();
    }

    @Transactional
    public List<Sportsman> getSportsmanWhereAgectIsAdult() {
        return sportsmanDao.listSportsmanWhereAgectIsAdult();
    }

    @Transactional
    public List<Object> getSportsmanSomeColumns() {
        return sportsmanDao.listSportsmanSomeColumns();
    }

    @Transactional
    public List<Object> getTakePartQuery() {
        return sportsmanDao.takePartQuery();
    }

    @Transactional
    public List<Object> getCompetitionQuery() {
        return sportsmanDao.competitionQuery();
    }

    @Transactional
    public List<Object> getSportsmanQuery() {
        return sportsmanDao.sportsmanQuery();
    }
}
