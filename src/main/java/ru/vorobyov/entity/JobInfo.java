package ru.vorobyov.entity;

public class JobInfo {
    private String position;
    private Boolean remoteWork;
    private int worker_id;

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
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
