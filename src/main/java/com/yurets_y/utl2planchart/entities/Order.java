package com.yurets_y.utl2planchart.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date created;

    @Temporal(TemporalType.DATE)
    private Date closed;

    @ManyToOne(cascade = CascadeType.ALL,    targetEntity=Station.class)
    @CollectionTable(name="send_station", joinColumns = @JoinColumn(name="station_id"))
    private Station sendStation;

    @ManyToOne(cascade = CascadeType.ALL,    targetEntity=Station.class)
    @CollectionTable(name="receive_station", joinColumns = @JoinColumn(name="station_id"))
    private Station receiveStation;

    private String note;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @ElementCollection(targetClass=ChartEntity.class)
    private Set<ChartEntity> chartElements = new LinkedHashSet<>();



    public Station getSendStation() {
        return sendStation;
    }

    public void setSendStation(Station sendStation) {
        this.sendStation = sendStation;
    }

    public Station getReceiveStation() {
        return receiveStation;
    }

    public void setReceiveStation(Station receiveStation) {
        this.receiveStation = receiveStation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public Set<ChartEntity> getChartElements() {
        return chartElements;
    }

    public void setChartElements(Set<ChartEntity> chartElements) {
        this.chartElements = chartElements;
    }

}
