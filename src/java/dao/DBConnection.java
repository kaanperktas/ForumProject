
package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    private Connection connection;
     public Connection getConnection() {
        if (this.connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
<<<<<<< HEAD
                this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forumDB", "postgres", "12345");
=======
                this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/forumDB", "postgres", "12345");
>>>>>>> d9e51a2c6742cd5792715f403686e0ec8f8debb2
                

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
