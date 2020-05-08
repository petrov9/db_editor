package com.cheersport.service;

import com.cheersport.dao.CompetitionDao;
import com.cheersport.model.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionDao competitionDao;

    public void setCompetitionDao(CompetitionDao CompetitionDao) {
        this.competitionDao = CompetitionDao;
    }

    @Transactional
    public List<Competition> listCompetition() {
        return competitionDao.listCompetition();

        }
    @Transactional
    public void addCompetition(Competition c) {
        competitionDao.addCompetition(c);
    }

    @Transactional
    public void deleteCompetition(int id) {
        competitionDao.deleteCompetition(id);
    }

    @Transactional
    public Competition getCompetition(int id) {
        return competitionDao.get(id);
    }
}
