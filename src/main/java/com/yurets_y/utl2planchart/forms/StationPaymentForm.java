package com.yurets_y.utl2planchart.forms;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StationPaymentForm {

    @NotNull
    @Digits(integer = 2, fraction = 3, message = "{javax.validation.constraints.Digits.message}")
    private float tarifKoef;
    @Digits(integer = 2, fraction = 2, message = "{javax.validation.constraints.Digits.message}")
    private float tarifDistUZ;
    @Digits(integer = 2, fraction = 2, message = "{javax.validation.constraints.Digits.message}")
    private float tarifDistClient;

    @NotNull
    @Digits(integer = 2, fraction = 0, message = "{javax.validation.constraints.Digits.message}")
    private int vagonCount;

    private boolean tarifDiscount;

    private boolean oneDayWork;

    @Digits(integer = 3, fraction = 0, message = "{javax.validation.constraints.Digits.message}")
    private int shuntingTime;

    private boolean weighting;

    private boolean weightingWithUZ;

    private boolean radiationOverpay;


    public float getTarifKoef() {
        return tarifKoef;
    }

    public void setTarifKoef(float tarifKoef) {
        this.tarifKoef = tarifKoef;
    }

    public float getTarifDistUZ() {
        return tarifDistUZ;
    }

    public void setTarifDistUZ(float tarifDistUZ) {
        this.tarifDistUZ = tarifDistUZ;
    }

    public float getTarifDistClient() {
        return tarifDistClient;
    }

    public void setTarifDistClient(float tarifDistClient) {
        this.tarifDistClient = tarifDistClient;
    }

    public int getVagonCount() {
        return vagonCount;
    }

    public void setVagonCount(int vagonCount) {
        this.vagonCount = vagonCount;
    }

    public boolean isTarifDiscount() {
        return tarifDiscount;
    }

    public void setTarifDiscount(boolean tarifDiscount) {
        this.tarifDiscount = tarifDiscount;
    }

    public boolean isOneDayWork() {
        return oneDayWork;
    }

    public void setOneDayWork(boolean oneDayWork) {
        this.oneDayWork = oneDayWork;
    }

    public int getShuntingTime() {
        return shuntingTime;
    }

    public void setShuntingTime(int shuntingTime) {
        this.shuntingTime = shuntingTime;
    }

    public boolean isWeighting() {
        return weighting;
    }

    public void setWeighting(boolean weighting) {
        this.weighting = weighting;
    }

    public boolean isWeightingWithUZ() {
        return weightingWithUZ;
    }

    public void setWeightingWithUZ(boolean weightingWithUZ) {
        this.weightingWithUZ = weightingWithUZ;
    }

    public boolean isRadiationOverpay() {
        return radiationOverpay;
    }

    public void setRadiationOverpay(boolean radiationOverpay) {
        this.radiationOverpay = radiationOverpay;
    }

    @Override
    public String toString() {
        return "StationPaymentForm{" +
                "tarifKoef=" + tarifKoef +
                ", tarifDistUZ=" + tarifDistUZ +
                ", tarifDistClient=" + tarifDistClient +
                ", vagonCount=" + vagonCount +
                ", tarifDiscount=" + tarifDiscount +
                ", oneDayWork=" + oneDayWork +
                ", shuntingTime=" + shuntingTime +
                ", weighting=" + weighting +
                ", weightingWithUZ=" + weightingWithUZ +
                ", radiationOverpay=" + radiationOverpay +
                '}';
    }
}
