package com.example.licenta2022.models.network;

import java.util.List;

public class RoomServiceOrderModel {
    private String id;
    private String totalValue;
    private String orderTime;
    private List<RoomServiceModel> orderedItems;

    public RoomServiceOrderModel() {
    }

    public RoomServiceOrderModel(String id, String totalValue, List<RoomServiceModel> orderedItems) {
        this.id = id;
        this.totalValue = totalValue;
        this.orderedItems = orderedItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public List<RoomServiceModel> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<RoomServiceModel> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
