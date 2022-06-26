package moviedb2;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AccessData {

   
    private Connection connect() {
        String url = "jdbc:sqlite:C:/Users/Nikhil Bhelkire/Desktop/doc/Sqlite/FavMovies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void selectAll(){
        String sql = "SELECT * FROM Movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + 
                                   rs.getString("Name") + "\t" +
				   rs.getString("Actor") + "\t" +
				   rs.getString("Actress") + "\t" +
				   rs.getString("Director") + "\t" +
                                   rs.getInt("Year_Released"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        AccessData data = new AccessData();
        data.selectAll();
    }

}