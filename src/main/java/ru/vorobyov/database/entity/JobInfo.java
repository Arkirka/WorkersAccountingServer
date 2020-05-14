package ru.vorobyov.database.entity;

public class JobInfo {
    private String position;
    private Boolean remoteWork;
    private int workerId;

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public void createTable() {

    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getRemoteWork() {
        return remoteWork;
    }

    public void setRemoteWork(Boolean remoteWork) {
        this.remoteWork = remoteWork;
    }
}
