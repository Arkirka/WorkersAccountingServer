package ru.vorobyov.database.dao;

import ru.vorobyov.database.entity.Worker;

import java.sql.SQLException;
import java.util.List;

public interface WorkerDAO {

    //create
    void add(Worker worker);

    //read
    List<Worker> getAll() ;

    Worker getByAddressId(int id);

    //update
    void update(Worker worker);

    //delete
    void remove(Worker worker);

    void createTable() throws SQLException;
}
