package com.cheersport.dao;

import com.cheersport.model.Club;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClubDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(ClubDao.class);

    @SuppressWarnings("unchecked")
    public List<Club> listClub() {
        Session session = sessionFactory.getCurrentSession();
        List<Club> clubs = session.createQuery("SELECT c FROM Club c").list();

        return clubs;
    }

    public void addClub(Club c) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(c);
    }

    public void deleteClub(int id) {
        Session session = sessionFactory.getCurrentSession();
        Club club = get(id);
        session.delete(club);
    }

    public Club get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Club club = (Club) session.createQuery("SELECT c FROM Club c where c.id = " + id).uniqueResult();

        return club;
    }
}
