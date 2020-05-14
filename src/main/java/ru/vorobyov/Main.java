package ru.vorobyov;

import ru.vorobyov.bl.Util;

import java.io.IOException;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws IOException {

        Util util = new Util();
        Connection connection = util.getConnection();


    }
}
