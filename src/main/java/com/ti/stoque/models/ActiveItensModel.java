package com.ti.stoque.models;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "itens_tb")
public class ActiveItensModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;
    @JoinColumn(name = "bar_code")
    private long barCorde;
    @JoinColumn(name = "item")
    private String itemName;
    @JoinColumn(name = "mark")
    private String markName;
    @JoinColumn(name = "amount")
    private int amount;
    @JoinColumn(name = "created_date")
    private LocalDateTime createdDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getBarCorde() {
        return barCorde;
    }

    public void setBarCorde(long barCorde) {
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
