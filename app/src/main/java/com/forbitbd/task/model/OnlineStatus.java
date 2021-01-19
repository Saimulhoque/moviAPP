package com.forbitbd.task.model;

public class OnlineStatus {

    private String Status;
    private boolean is_active;

    public OnlineStatus() {
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}
