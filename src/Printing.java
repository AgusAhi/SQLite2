import java.sql.*;
public class Printing {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:futbol";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            printTeam(conn);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void printTeam(Connection conn) throws SQLException {
        Statement stm = null;
        String query = "SELECT TEAM_NAME, FIELD, CITY, PROVINCE FROM TEAM";
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String team = rs.getString("TEAM_NAME");
                System.out.println("Team: "+team);
                String field = rs.getString("FIELD");
                System.out.println("Field: "+field);
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
        }
    }

    public static void printTeamWithId(Connection conn) throws SQLException {
        Statement stm = null;
        String query = "SELECT TEAM_ID, TEAM_NAME, FIELD, CITY, PROVINCE FROM TEAM";
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("TEAM_ID");
                System.out.println("Player_id: " + id);
                String team = rs.getString("TEAM_NAME");
                System.out.println("Team: "+team);
                String field = rs.getString("FIELD");
                System.out.println("Field: "+field);
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
        }
    }
}
