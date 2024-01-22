import java.sql.*;
public class LoadTables {
    public static void loadTeams(Connection conn)
            throws SQLException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO TEAM "
                    + "VALUES (1, 'ESTEPONA', 'MONTERROSO', 'ESTEPONA', "
                    + " 'MALAGA','29680')");
            stmt.executeUpdate("INSERT INTO TEAM "
                    + "VALUES (2, 'ALCORCON', 'SANTO DOMINGO', 'ALCORCON', "
                    + " 'MADRID','28924')");
            stmt.executeUpdate("INSERT INTO TEAM "
                    + "VALUES (3, 'PORCUNA', 'SAN CRISTOBAL', 'PORCUNA', "
                    + " 'JAEN','23790')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
        }
    }

    public static void loadPlayers(Connection conn) throws SQLException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();

            //Estepona

            stmt.executeUpdate("INSERT INTO PLAYERS "
                    +"VALUES (1, 1, 'JOSE ANTONIO', 1, 42)");
            stmt.executeUpdate("INSERT INTO PLAYERS "
                    +"VALUES (2, 1, 'IGNACIO', 2, 62)");
            stmt.executeUpdate("INSERT INTO PLAYERS "
                    +"VALUES (3, 1, 'DIEGO', 3, 20)");

            //Alcorcon

            stmt.executeUpdate("INSERT INTO PLAYERS "
                    +"VALUES (4, 2, 'TURRION', 1, 37)");
            stmt.executeUpdate("INSERT INTO PLAYERS "
                    +"VALUES (5, 2, 'LUIS ABEL', 2, 37)");
            stmt.executeUpdate("INSERT INTO PLAYERS "
                    +"VALUES (6, 2, 'ISAAC', 3, 40)");
            stmt.executeUpdate("INSERT INTO PLAYERS "
                    +"VALUES (7, 3, 'JUAN FRANCISCO', 1, 33)");
            stmt.executeUpdate("INSERT INTO PLAYERS "
                    +"VALUES (8, 3, 'PARRA', 2, 37)");
            stmt.executeUpdate("INSERT INTO PLAYERS "
                    +"VALUES (9, 3, 'RAUL', 3, 19)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
        }
    }
}