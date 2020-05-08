package com.cheersport.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @Column(name = "teamid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "clubid")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "coachid")
    private Coach coach;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public int getClubId() {
        if (club != null) {
            return club.getId();
        } else {
            return 0;
        }
    }

    public void setClubId(int clubId) {
        Club club = new Club();
        club.setId(clubId);
        this.club = club;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getCoachId() {
        if (coach != null) {
            return coach.getId();
        } else {
            return 0;
        }
    }

    public void setCoachId(int coachId) {
        Coach coach = new Coach();
        coach.setId(coachId);
        this.coach = coach;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", club=" + club +
                ", coach=" + coach +
                '}';
    }
}
