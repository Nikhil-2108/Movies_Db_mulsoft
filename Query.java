package moviedb2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class Query{
		
		
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
	
	public void Parameter(){
               String sql = "SELECT * from Movies where Director like '%Rajamouli%';";
        
        try (Connection conn = this.connect();
              PreparedStatement pstmt  = conn.prepareStatement(sql)){
           
            	ResultSet rs  = pstmt.executeQuery();
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
        	Query param = new Query();
        	param.Parameter();
    }

}