package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:card.s3db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE card (id INTEGER, number TEXT, pin TEXT, balance INTEGER DEFAULT 0)");
            //statement.executeUpdate("DROP TABLE card");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Menu mm = new Menu();
        mm.accountMenuSwitch();
    }
}
