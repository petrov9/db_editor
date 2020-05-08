package com.cheersport.service;

import com.cheersport.dao.TeamDao;
import com.cheersport.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamDao teamDao;

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Transactional
    public List<Team> listTeam() {
        return teamDao.listTeam();

        }
    @Transactional
    public void addTeam(Team c) {
        teamDao.addTeam(c);
    }

    @Transactional
    public void deleteTeam(int id) {
        teamDao.deleteTeam(id);
    }

    @Transactional
    public Team getTeam(int id) {
        return teamDao.get(id);
    }
}
