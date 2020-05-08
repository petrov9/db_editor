package com.cheersport.dao;

import com.cheersport.model.Coach;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoachDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(CoachDao.class);

    @SuppressWarnings("unchecked")
    public List<Coach> listCoach() {
        Session session = sessionFactory.getCurrentSession();
        List<Coach> coaches = session.createQuery("SELECT c FROM Coach c").list();

        return coaches;
    }

    public void addCoach(Coach c) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(c);
    }

    public void deleteCoach(int id) {
        Session session = sessionFactory.getCurrentSession();
        Coach coach = get(id);
        session.delete(coach);
    }

    public Coach get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Coach coach = (Coach) session.createQuery("SELECT c FROM Coach c where c.id = " + id).uniqueResult();

        return coach;
    }
}
