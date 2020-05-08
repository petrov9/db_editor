package com.cheersport.dao;

import com.cheersport.model.Club;
import com.cheersport.model.Competition;
import com.cheersport.model.Takepart;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TakepartDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(TakepartDao.class);

    @SuppressWarnings("unchecked")
    public List<Takepart> listTakepart() {
        Session session = sessionFactory.getCurrentSession();
        List<Takepart> takeparts = session.createQuery("SELECT t FROM Takepart t").list();

        return takeparts;
    }

    public void addTakepart(Takepart t) {
        Session session = sessionFactory.getCurrentSession();
        Club club = (Club) session.createQuery("select c from Club c where c.id = " + t.getClubId()).uniqueResult();
        Competition competition = (Competition) session.createQuery("select c from Competition c where c.id = " + t.getCompetitionId()).uniqueResult();

        t.setClub(club);
        t.setCompetition(competition);

        session.saveOrUpdate(t);
    }

    public void deleteTakepart(int id) {
        Session session = sessionFactory.getCurrentSession();
        Takepart takepart = get(id);
        session.delete(takepart);
    }

    public Takepart get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Takepart takepart = (Takepart) session.createQuery("SELECT t FROM Takepart t where t.id = " + id).uniqueResult();

        return takepart;
    }
}
