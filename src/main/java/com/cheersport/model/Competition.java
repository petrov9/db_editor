package com.cheersport.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "competition")
public class Competition {
    @Id
    @Column(name = "competitionid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateln")
    private Date dateln;

    @Column(name = "place")
    private String place;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competition that = (Competition) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateln != null ? !dateln.equals(that.dateln) : that.dateln != null) return false;
        return place != null ? place.equals(that.place) : that.place == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateln != null ? dateln.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        return result;
    }

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

    public String getDatelnText() {
        if (dateln == null)
            return null;

        return new SimpleDateFormat("yyyy-MM-dd").format(dateln);
    }

    public void setDatelnText(String datelnText) throws ParseException {
        this.dateln = new SimpleDateFormat("yyy-MM-dd").parse(datelnText);
    }

    public Date getDateln() {
        return dateln;
    }

    public void setDateln(Date dateln) {
        this.dateln = dateln;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateln=" + dateln +
                ", place='" + place + '\'' +
                '}';
    }
}
