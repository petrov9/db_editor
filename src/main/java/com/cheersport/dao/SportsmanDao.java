package com.cheersport.dao;

import com.cheersport.model.Sportsman;
import com.cheersport.model.Team;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SportsmanDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(SportsmanDao.class);

    @SuppressWarnings("unchecked")
    public List<Sportsman> listSportsman() {
        Session session = sessionFactory.getCurrentSession();
        List<Sportsman> sportsmanList = session.createQuery("SELECT s FROM Sportsman s").list();
        for(Sportsman p: sportsmanList){
            logger.info(p.toString());
        }
        return sportsmanList;
    }

    public void addSportsman(Sportsman s) {
        Session session = sessionFactory.getCurrentSession();
        Team team = (Team) session.createQuery("select t from Team t where t.id =" + s.getTeamId()).uniqueResult();
        s.setTeam(team);
        session.saveOrUpdate(s);
    }

    public void deleteSportsman(int id) {
        Session session = sessionFactory.getCurrentSession();
        Sportsman sportsman = get(id);
        session.delete(sportsman);
    }

    public Sportsman get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Sportsman sportsman = (Sportsman) session.createQuery("SELECT s FROM Sportsman s where s.id = " + id).uniqueResult();

        return sportsman;
    }

    public List<Sportsman> listSportsmanOrderByPlace() {
        Session session = sessionFactory.getCurrentSession();
        List<Sportsman> sportsmanList = session.createQuery("SELECT s FROM Sportsman s order by s.place").list();

        return sportsmanList;
    }

    public List<Sportsman> listSportsmanWhereAgectIsAdult() {
        Session session = sessionFactory.getCurrentSession();
        List<Sportsman> sportsmanList = session.createQuery("SELECT s FROM Sportsman s where s.agect = 'взрослый'").list();

        return sportsmanList;
    }

    public List<Object> listSportsmanSomeColumns() {
        Session session = sessionFactory.getCurrentSession();
        List<Object> sportsmanList = session.createQuery("SELECT s.id, s.name, s.rank FROM Sportsman s " +
                "where s.name in (select s1.name from Sportsman s1 where s1.rank = 'МС')").list();

        return sportsmanList;
    }

    public List<Object> takePartQuery() {
        Session session = sessionFactory.getCurrentSession();
        /*select t.clubId, c.name, c.dateln, c.place from Takepart t inner join Competition c on t.competitionId = c.id*/
        List<Object> list = session.createSQLQuery("select t.clubId, c.name, c.dateln, c.place from Takepart t " +
                "inner join Competition c on t.competitionId = c.competitionid").list();

        return list;
    }

    public List<Object> competitionQuery() {
        Session session = sessionFactory.getCurrentSession();
        List<Object> list = session.createSQLQuery("select c.place, count(c) as count_competition from Competition c group by c.place").list();

        return list;
    }

    public List<Object> sportsmanQuery() {
        Session session = sessionFactory.getCurrentSession();
        List<Object> list = session.createSQLQuery("select s.teamId, count(s) as count_team from Sportsman s group by s.teamId").list();

        return list;
    }
}
