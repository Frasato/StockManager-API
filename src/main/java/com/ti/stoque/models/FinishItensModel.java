package com.ti.stoque.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "finish_itens_tb")
public class FinishItensModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "bar_code", nullable = false)
    private String barCorde;
    @Column(name = "item", nullable = false)
    private String itemName;
    @Column(name = "mark")
    private String markName;
    @Column(name = "amount", nullable = false)
    private int amount;
    @Column(name = "sector", nullable = false)
    private String sectorName;
    @Column(name = "city", nullable = false)
    private String cityName;
    @Column(name = "out_date")
    private String outDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBarCorde() {
        return barCorde;
    }

    public void setBarCorde(String barCorde) {
        this.barCorde = barCorde;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    @PrePersist
    protected void onCreate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dateFormatted = now.format(formatter);
        this.outDate = dateFormatted;
    }
}
