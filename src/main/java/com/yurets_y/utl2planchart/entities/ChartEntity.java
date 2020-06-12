package com.yurets_y.utl2planchart.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="chart_entity_table")
public class ChartEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;
    private int confirmed;
    private int declared;
    private int shipped;

    public ChartEntity() {
    }

    public ChartEntity(Date date) {
        this.date = date;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeclared() {
        return declared;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartEntity chartCell = (ChartEntity) o;
        return date.equals(chartCell.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    public void setDeclared(int declared) {
        this.declared = declared;
    }

    public int getShipped() {
        return shipped;
    }

    public void setShipped(int shipped) {
        this.shipped = shipped;
    }

    @Override
    public String toString() {
        return "ChartCell{" +
                "date=" + date +
                ", confirmed=" + confirmed +
                ", declared=" + declared +
                ", shipped=" + shipped +
                '}';
    }

}