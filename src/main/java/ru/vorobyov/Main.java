package ru.vorobyov;

import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.server.logic.ServerUtil;

import java.io.IOException;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws IOException {

        Connection connection = DatabaseUtil.getConnection();

        ServerUtil serverUtil = new ServerUtil();

    }
}
