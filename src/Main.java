import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:futbol";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            CreateTables.createTeam(conn);
            CreateTables.createPlayer(conn);
            LoadTables.loadTeams(conn);
            LoadTables.loadPlayers(conn);
            Printing.printTeam(conn); /// LO NUEVO
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }


}
