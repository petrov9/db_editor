package com.cheersport.dao;

import com.cheersport.model.Competition;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompetitionDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(CompetitionDao.class);

    @SuppressWarnings("unchecked")
    public List<Competition> listCompetition() {
        Session session = sessionFactory.getCurrentSession();
        List<Competition> competitions = session.createQuery("SELECT c FROM Competition c").list();

        return competitions;
    }

    public void addCompetition(Competition c) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(c);
    }

    public void deleteCompetition(int id) {
        Session session = sessionFactory.getCurrentSession();
        Competition competition = get(id);
        session.delete(competition);
    }

    public Competition get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Competition competition = (Competition) session.createQuery("SELECT c FROM Competition c where c.id = " + id).uniqueResult();

        return competition;
    }
}
