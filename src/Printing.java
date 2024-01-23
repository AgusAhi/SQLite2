import javax.swing.plaf.nimbus.State;
import java.sql.*;
public class Printing {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:futbol";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("-- Ejemplo --");
            printTeam(conn);
            System.out.println();
            System.out.println("-- Ejercicio 2 --");
            printTeamWithId(conn, 1);
            System.out.println();
            System.out.println("---Ejercicio 3--");
            printAllPlayersFromTeam(conn, "ALCORCON");
            System.out.println();
            System.out.println("---Ejercicio 4--");
            printSortedTeamPlayers(conn);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    private static void printPlayers(ResultSet rs) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("PLAYER_ID");
            System.out.println("ID: "+id);
            String name = rs.getString("NOMBRE");
            System.out.println("Name: "+name);
            int dorsal = rs.getInt("DORSAL");
            System.out.println("Dorsal: "+ dorsal);
            int age = rs.getInt("EDAD");
            System.out.println("Age: "+ age);
            System.out.println("************************");
        }
    }

    public static void printTeam(Connection conn) throws SQLException {
        Statement stm = null;
        ResultSet rs = null;
        String query = "SELECT TEAM_NAME, FIELD, CITY, PROVINCE FROM TEAM";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                String team = rs.getString("TEAM_NAME");
                System.out.println("Team: "+ team);
                String field = rs.getString("FIELD");
                System.out.println("Field: "+ field);
                String city = rs.getString("CITY");
                System.out.println("City: "+ city);
                String province = rs.getString("PROVINCE");
                System.out.println("Province: "+ province);
                System.out.println("************************");
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

    public static void printTeamWithId(Connection conn, int teamId) throws SQLException {
        Statement stm = null;
        ResultSet rs = null;
        String query = "SELECT * FROM PLAYERS where TEAM_ID = " + teamId;
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            printPlayers(rs);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

    public static void printAllPlayersFromTeam(Connection conn, String teamStr) throws SQLException {
        Statement stm = null;
        ResultSet rs = null;
        String query = "SELECT * FROM PLAYERS WHERE TEAM_ID" +
                "= (SELECT TEAM_ID FROM TEAM WHERE TEAM_NAME = '" + teamStr + "')";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            printPlayers(rs);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

    public static void printSortedTeamPlayers(Connection conn) throws SQLException {
        Statement stm = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM PLAYERS JOIN TEAM " +
                "ON PLAYERS.TEAM_ID = TEAM.TEAM_ID " +
                "ORDER BY TEAM_NAME";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(SQL);
            printPlayers(rs);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }
}
