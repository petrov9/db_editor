package com.cheersport.service;

import com.cheersport.dao.ClubDao;
import com.cheersport.model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    private ClubDao clubDao;

    public void setClubDao(ClubDao clubDao) {
        this.clubDao = clubDao;
    }

    @Transactional
    public List<Club> listClub() {
        return clubDao.listClub();

        }
    @Transactional
    public void addClub(Club c) {
        clubDao.addClub(c);
    }

    @Transactional
    public void deleteClub(int id) {
        clubDao.deleteClub(id);
    }

    @Transactional
    public Club getClub(int id) {
        return clubDao.get(id);
    }
}
