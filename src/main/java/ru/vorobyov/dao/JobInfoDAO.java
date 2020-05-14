package ru.vorobyov.dao;

import ru.vorobyov.entity.JobInfo;
import ru.vorobyov.entity.Worker;

import java.sql.SQLException;
import java.util.List;

public interface JobInfoDAO {

    //create
    void add(JobInfo jobInfo);

    //read
    List<JobInfo> getAll() ;

    JobInfo getByAddressId(int id);

    //update
    void update(JobInfo jobInfo);

    //delete
    void remove(JobInfo jobInfo);

    void createTable() throws SQLException;
}
