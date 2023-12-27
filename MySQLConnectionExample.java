import java.sql.*;

public class MySQLConnectionExample

{

    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/MySQL113"; // Replace 'my_database' with your database name
        String user = "root"; // Replace 'your_username' with your MySQL username
        String password = "afafadfaf"; // Replace 'your_password' with your MySQL password

        // SQL query to execute
        String sqlQuery = "SELECT * FROM your_table"; // Replace 'your_table' with your table name

        try (Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            // Print column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Print query results
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
