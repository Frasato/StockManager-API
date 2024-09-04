package com.ti.stoque.dtos;

import com.ti.stoque.models.ActiveItensModel;

import java.util.UUID;

public class TakeOutItemDTO {

    private UUID id;
    private int removedAmount;
    private String city;
    private String sector;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getRemovedAmount() {
        return removedAmount;
    }

    public void setRemovedAmount(int removedAmount) {
        this.removedAmount = removedAmount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
