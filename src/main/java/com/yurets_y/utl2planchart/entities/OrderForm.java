package com.yurets_y.utl2planchart.entities;

public class OrderForm {

    private Integer sendStationCode;

    private Integer receiveStationCode;

    private String note;

    public Integer getSendStationCode() {
        return sendStationCode;
    }

    public void setSendStationCode(Integer sendStationCode) {
        this.sendStationCode = sendStationCode;
    }

    public Integer getReceiveStationCode() {
        return receiveStationCode;
    }

    public void setReceiveStationCode(Integer receiveStationCode) {
        this.receiveStationCode = receiveStationCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
