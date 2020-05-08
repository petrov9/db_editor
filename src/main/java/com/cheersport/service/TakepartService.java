package com.cheersport.service;

import com.cheersport.dao.TakepartDao;
import com.cheersport.model.Takepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TakepartService {

    @Autowired
    private TakepartDao takepartDao;

    public void setTakepartDao(TakepartDao TakepartDao) {
        this.takepartDao = TakepartDao;
    }

    @Transactional
    public List<Takepart> listTakepart() {
        return takepartDao.listTakepart();

        }
    @Transactional
    public void addTakepart(Takepart c) {
        takepartDao.addTakepart(c);
    }

    @Transactional
    public void deleteTakepart(int id) {
        takepartDao.deleteTakepart(id);
    }

    @Transactional
    public Takepart getTakepart(int id) {
        return takepartDao.get(id);
    }
}
