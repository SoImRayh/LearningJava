import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:base.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("DROP TABLE IF EXISTS terminalroot");
            statement.executeUpdate("CREATE TABLE terminalroot (id INTEGER, name STRING)");
            statement.executeUpdate("INSERT INTO terminalroot VALUES(1, 'Marcos Oliveira')");
            statement.executeUpdate("INSERT INTO terminalroot VALUES(2, 'James Gosling')");

            ResultSet rs = statement.executeQuery("SELECT * FROM terminalroot");
            while(rs.next()) {
                // Ler os dados inseridos
                System.out.println("NOME DO CARA  : " + rs.getString("name"));
                System.out.println("IDENTIFICAÇÃO : " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
