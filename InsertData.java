package moviedb2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertData {

   
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

    
    public void insert(String Name,String Actor,String Actress,String Director, Integer Year_Released) {
        String sql = "INSERT INTO Movies(Name,Actor,Actress,Director,Year_Released) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            	pstmt.setString(1, Name);
		pstmt.setString(2, Actor);
		pstmt.setString(3, Actress);
		pstmt.setString(4, Director);
            	pstmt.setInt(5, Year_Released);
            	pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        InsertData data = new InsertData();
        data.insert("KGF2","Yash","Srinedhi","Prashanth", 2022);
        data.insert("KGF","Yash","Srinedhi","Prashanth", 2018);
        data.insert("Bahubali 1","Prabhas","Thamanna","Rajamouli", 2015);
        data.insert("Bahubali 2","Prabhas","Anushka,Thamanna","Rajamouli", 2017);
	data.insert("RRR","Jr.NTR,Ram charan","Alia,Oliva","Rajamouli", 2022);
    }

}
