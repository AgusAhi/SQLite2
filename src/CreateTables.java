import java.sql.*;
public class CreateTables {

    public static void createTeam(Connection conn) throws SQLException {
        String createString = "create table TEAM" +
                "(TEAM_ID integer NOT NULL," +
                "TEAM_NAME varchar(40) NOT NULL," +
                "FIELD varchar(40) NOT NULL," +
                "CITY varchar(20) NOT NULL, " +
                "PROVINCE varchar(20) NOT NULL," +
                "ZIP_CODE char(5)," +
                "PRIMARY KEY (TEAM_ID))";
        Statement stm = null;
        try {
            stm = conn.createStatement();
            stm.executeUpdate(createString);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
        }
    }


    public static void createPlayer(Connection conn) throws SQLException {
        String createString = "create table PLAYERS (PLAYER_ID integer NOT NULL," +
                "TEAM_ID integer NOT NULL," +
                "NOMBRE varchar(40) NOT NULL," +
                "DORSAL integer NOT NULL, "+
                "EDAD integer NOT NULL," +
                "PRIMARY KEY (PLAYER_ID),"+
                "FOREIGN KEY (TEAM_ID) " +
                "REFERENCES TEAM (TEAM_ID))";
        Statement stm = null;
        try {
            stm = conn.createStatement();
            stm.executeUpdate(createString);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
        }
    }
}
