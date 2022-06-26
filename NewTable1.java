package moviedb2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class NewTable1 {

    public static void NewTable() {
        String url = "jdbc:sqlite:C:/Users/Nikhil Bhelkire/Desktop/doc/Sqlite/FavMovies.db";
        String sql = "CREATE TABLE IF NOT EXISTS Movies (\n"
                + " id integer PRIMARY KEY,\n"
                + " Name text NOT NULL,\n"
		+ " Actor text NOT NULL,\n"
		+ " Actress text NOT NULL,\n"
		+ " Director text NOT NULL,\n"
		+ " Year_Released integer NOT NULL\n"
                + ");";

        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        NewTable();
    }

}
