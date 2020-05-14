package ru.vorobyov.database.service;

import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.dao.JobInfoDAO;
import ru.vorobyov.database.entity.JobInfo;
import ru.vorobyov.database.entity.Worker;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobInfoService implements JobInfoDAO {
    Connection connection;

    public JobInfoService() throws IOException {
        connection = DatabaseUtil.getConnection();
    }

    @Override
    public void add(JobInfo jobInfo) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO JOBINFO (POSITION, REMOTEWORK, WORKER_ID) VALUES(?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, jobInfo.getPosition());
            preparedStatement.setBoolean(2, jobInfo.getRemoteWork());
            preparedStatement.setInt(3, jobInfo.getWorkerId());

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
    public List<JobInfo> getAll() throws SQLException {
        List<JobInfo> jobInfoList = new ArrayList<>();

        String sql = "SELECT POSITION , REMOTEWORK, WORKER_ID FROM JOBINFO";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                JobInfo jobInfo = new JobInfo();

               jobInfo.setPosition(resultSet.getString("POSITION"));
               jobInfo.setRemoteWork(resultSet.getBoolean("REMOTEWORK"));
               jobInfo.setWorkerId(resultSet.getInt("WORKER_ID"));

                jobInfoList.add(jobInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return jobInfoList;
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
            preparedStatement.setInt(3, jobInfo.getWorkerId());

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

            preparedStatement.setInt(1, jobInfo.getWorkerId());

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
