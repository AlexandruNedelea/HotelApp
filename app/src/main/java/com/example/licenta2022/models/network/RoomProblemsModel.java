package com.example.licenta2022.models.network;

import com.example.licenta2022.helpers.DateTimeHelper;

public class RoomProblemsModel {
    private String id;
    private String name;
    private String date;

    public RoomProblemsModel() {
    }

    public RoomProblemsModel(String id, String name) {
        this.id = id;
        this.name = name;
        date = DateTimeHelper.getInstance().getCurrentDateTimeInString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
