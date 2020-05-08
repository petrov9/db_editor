package com.cheersport.model;

import javax.persistence.*;

@Entity
@Table(name = "takepart")
public class Takepart {
    @Id
    @Column(name = "takepartid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "clubid")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "competitionid")
    private Competition competition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public int getCompetitionId() {
        if (competition != null) {
            return competition.getId();
        } else {
            return 0;
        }
    }

    public void setCompetitionId(int competitionId) {
        Competition competition = new Competition();
        competition.setId(competitionId);
        this.competition = competition;
    }

    @Override
    public String toString() {
        return "Takepart{" +
                "id=" + id +
                ", club=" + club +
                ", competition=" + competition +
                '}';
    }
}
