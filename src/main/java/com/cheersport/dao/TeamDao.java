package com.cheersport.dao;

import com.cheersport.model.Club;
import com.cheersport.model.Coach;
import com.cheersport.model.Team;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(TeamDao.class);

    @SuppressWarnings("unchecked")
    public List<Team> listTeam() {
        Session session = sessionFactory.getCurrentSession();
        List<Team> teams = session.createQuery("SELECT t FROM Team t").list();

        return teams;
    }

    public void addTeam(Team t) {
        Session session = sessionFactory.getCurrentSession();
        Club club = (Club) session.createQuery("select c from Club c where c.id = " + t.getClubId()).uniqueResult();
        Coach coach = (Coach) session.createQuery("select c from Coach c where c.id = " + t.getClubId()).uniqueResult();

        t.setClub(club);
        t.setCoach(coach);

        session.saveOrUpdate(t);
    }

    public void deleteTeam(int id) {
        Session session = sessionFactory.getCurrentSession();
        Team team = get(id);
        session.delete(team);
    }

    public Team get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Team team = (Team) session.createQuery("SELECT t FROM Team t where t.id = " + id).uniqueResult();

        return team;
    }
}
