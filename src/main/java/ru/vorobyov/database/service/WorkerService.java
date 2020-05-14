package ru.vorobyov.database.service;

import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.dao.WorkerDAO;
import ru.vorobyov.database.entity.Worker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class WorkerService implements WorkerDAO {
    Connection connection;

    public WorkerService() throws IOException {
        connection = DatabaseUtil.getConnection();
    }

    @Override
    public void add(Worker worker) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO WORKER (PREVIEW, NAME, LASTNAME, BIRTHDAY, AGE, ADDRESS) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, worker.getPreview());
            preparedStatement.setString(2, worker.getName());
            preparedStatement.setString(3, worker.getLastName());
            preparedStatement.setString(4, worker.getBirthday());
            preparedStatement.setInt(5, worker.getAge());
            preparedStatement.setString(6, worker.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Worker> getAll() {
        return null; //TODO if needed
    }

    @Override
    public Worker getByAddressId(int id) {
        return null; //TODO if needed
    }

    @Override
    public void update(Worker worker) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE WORKER SET PREVIEW=?, NAME=?, LASTNAME=?, BIRTHDAY=?, AGE=?, ADDRESS=? WHERE WORKER_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, worker.getPreview());
            preparedStatement.setString(2, worker.getName());
            preparedStatement.setString(3, worker.getLastName());
            preparedStatement.setString(4, worker.getBirthday());
            preparedStatement.setInt(5, worker.getAge());
            preparedStatement.setString(6, worker.getAddress());
            preparedStatement.setInt(7, worker.getWorkerId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void remove(Worker worker) {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM WORKER WHERE WORKER_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, worker.getWorkerId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table IF NOT EXISTS Worker (\n" +
                "    worker_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    preview VARCHAR(100),\n" +
                "    name VARCHAR(10),\n" +
                "    lastName VARCHAR(15),\n" +
                "    birthday INT,\n" +
                "    age DATE,\n" +
                "    address VARCHAR(30)\n" +
                ");");
        stmt.close();
    }
}
