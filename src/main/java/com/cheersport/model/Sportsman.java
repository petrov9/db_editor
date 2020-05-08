package com.cheersport.model;

import com.cheersport.validator.IsDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;

@Entity
@Embeddable
@Table(name = "sportsman")
public class Sportsman {
    @Id
    @Column(name = "sportsmanid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "place")
    private String place;

    @Column(name = "rank")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "teamid", nullable = false)
    private Team team;

    @Column(name = "agect")
    private String agect;

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

    public String getBirthdayText() {
        if (birthday == null)
            return null;

        return new SimpleDateFormat("yyyy-MM-dd").format(birthday);
    }

    public void setBirthdayText(/*@Valid @IsDate(pattern = "yyyy-MM-dd") */String birthdayText) throws ParseException {
        this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayText);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getTeamId() {
        if (team != null) {
            return team.getId();
        } else {
            return 0;
        }
    }

    public void setTeamId(int teamId) {
        Team team = new Team();
        team.setId(teamId);
        this.team = team;
    }

    public String getAgect() {
        return agect;
    }

    public void setAgect(String agect) {
        this.agect = agect;
    }

    @Override
    public String toString() {
        return "Sportsman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", place='" + place + '\'' +
                ", rank='" + rank + '\'' +
                ", team=" + team +
                ", agect='" + agect + '\'' +
                '}';
    }
}
