
package com.cheersport;

import com.cheersport.model.Sportsman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Runner {

    @Test
    public void crud() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        read(session);
        create(session);
        session.close();
    }

    private void read(Session session) {
        List<Sportsman> sportsmanList = session.createQuery("SELECT s FROM Sportsman s").list();
        for (Sportsman s : sportsmanList) {
            System.out.println("List:" + s);
        }
    }

    private void create(Session session) {
        Sportsman sportsman = new Sportsman();
        sportsman.setName("Test name");
        sportsman.setBirthday(new Date());
        sportsman.setPlace("Запасной");
        sportsman.setRank("МК");
        sportsman.setTeamId(5);
        sportsman.setAgect("юниор");

        session.beginTransaction();
        session.save(sportsman);
        session.getTransaction().commit();
    }
}
