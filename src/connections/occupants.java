package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class occupants {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/hostelmanagement";
	private static final String username = "root";
	private static final String password = "root";
	private static Connection con;
	private static PreparedStatement pmst;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			displaymenu();
			System.out.println("Enter the choice");
			ch = sc.nextInt();
			switch(ch) {
			case 1:checkin();
			break;
			case 2:checkout();
			break;
			case 3: getdetailsofoccupants();
			break;
			case 4: getdetailsofoccupantsbyid();
			break;
			case 6:System.exit(0);
			break;
			default:
				System.out.println("invalid");
				
			
			}
			
		} while (ch>0); 
		
		
	}

	private static void getdetailsofoccupantsbyid() {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			String sql = "select * from occupants where occupant_id = ? ";
			pmst = con.prepareStatement(sql);
			System.out.println("Enter the id");
			pmst.setInt(1, sc.nextInt());
			ResultSet rs = pmst.executeQuery();
		
			while(rs.next()) {
				System.out.println("occupant_id:"+rs.getInt("occupant_id"));
				System.out.println("occupant_name:"+rs.getString("occupant_name"));
				System.out.println("occupant_age:"+rs.getInt("occupant_age"));
				System.out.println("occupant_gender:"+rs.getString("occupant_gender"));
				System.out.println("room_id:"+rs.getInt("room_id"));
			}
			
		
			pmst.close();
			con.close();
		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	private static void getdetailsofoccupants() {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			String sql = "select * from occupants";
			pmst = con.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
		
			while(rs.next()) {
				System.out.println("occupant_id:"+rs.getInt("occupant_id"));
				System.out.println("occupant_name:"+rs.getString("occupant_name"));
				System.out.println("occupant_age:"+rs.getInt("occupant_age"));
				System.out.println("occupant_gender:"+rs.getString("occupant_gender"));
				System.out.println("room_id:"+rs.getInt("room_id"));
			}
			
		
			pmst.close();
			con.close();
		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	private static void checkin() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/hostelmanagement";
			con = DriverManager.getConnection(url,username,password);
			String sql = "insert into occupants (occupant_name,occupant_age,occupant_gender,room_id) values(?,?,?,?)";
			pmst= con.prepareStatement(sql);
			System.out.println("Enter the name");
			pmst.setString(1, sc.next());
			System.out.println("Enter the occupant_age");
			pmst.setInt(2, sc.nextInt());
			System.out.println("Enter the gender");
			pmst.setString(3, sc.next());
			System.out.println("Enter the room_id");
			pmst.setInt(4, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Data is inserted");
			}
			else {
				System.out.println("Data is not inserted");
			}
			pmst.close();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	}

	private static void checkout() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			String sql = "delete  from occupants where occupant_id = ? ";
			pmst = con.prepareStatement(sql);
			System.out.println("Enter the id");
			pmst.setInt(1, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("data is deleted");
			
			}else {
				System.out.println("data is not deleted");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private static void displaymenu() {
		// TODO Auto-generated method stub
		System.out.println("\t1.checkin");
		System.out.println("\t2.checkout");
		System.out.println("\t3.show all information");
		System.out.println("\t4.show information by id");
		System.out.println("\t5.exit");
		
		
	}

}
