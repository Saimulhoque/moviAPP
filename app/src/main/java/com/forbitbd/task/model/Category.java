package com.forbitbd.task.model;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
    private String _id;
    private String name;
    private Date date;


    public Category() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
