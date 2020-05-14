package ru.vorobyov.service;

import ru.vorobyov.bl.Util;
import ru.vorobyov.dao.JobInfoDAO;
import ru.vorobyov.entity.JobInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JobInfoService implements JobInfoDAO {
    Connection connection;

    public JobInfoService() throws IOException {
        connection = Util.getConnection();
    }

    @Override
    public void add(JobInfo jobInfo) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO JOBINFO (POSITION, REMOTEWORK, WORKER_ID) VALUES(?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, jobInfo.getPosition());
            preparedStatement.setBoolean(2, jobInfo.getRemoteWork());
            preparedStatement.setInt(3, jobInfo.getWorker_id());

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
    public List<JobInfo> getAll() {
        return null; //TODO if needed
    }

    @Override
    public JobInfo getByAddressId(int id) {
        return null; //TODO if needed
    }

    @Override
    public void update(JobInfo jobInfo) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE JOBINFO SET POSITION=?, REMOTEWORK=? WHERE WORKER_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, jobInfo.getPosition());
            preparedStatement.setBoolean(2, jobInfo.getRemoteWork());
            preparedStatement.setInt(3, jobInfo.getWorker_id());

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
    public void remove(JobInfo jobInfo) {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM JOBINFO WHERE WORKER_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, jobInfo.getWorker_id());

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
        stmt.execute("CREATE TABLE IF NOT EXISTS JobInfo (\n" +
                "    position VARCHAR(30),\n" +
                "    remoteWork BOOLEAN,\n" +
                "    worker_id INT,\n" +
                "    FOREIGN KEY (worker_id) REFERENCES Worker(worker_id)\n" +
                ");");
        stmt.close();
    }
}
