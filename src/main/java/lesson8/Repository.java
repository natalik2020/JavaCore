package lesson8;

import java.sql.*;

public class Repository {
    public static void saveWeather(String city, String localDate, double temperature, String weatherText) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\database\\geekbrainsLesson8.db");
            Statement stmt = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Weather " +
                    "(city, localDate, temperature, weatherText) " +
                    "VALUES (?, ?, ?, ?);");
            ps.setString(1, city);
            ps.setString(2, localDate);
            ps.setDouble(3, temperature);
            ps.setString(4, weatherText);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void printAllWeather(String city) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\database\\geekbrainsLesson8.db");
            Statement stmt = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("SELECT id, weatherText FROM Weather WHERE city = ?");
            ps.setString(1, city);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String weatherText = rs.getString(2);
                Long id = rs.getLong(1);
                System.out.println(id + " " + weatherText);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
