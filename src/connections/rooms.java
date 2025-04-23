package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class rooms {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/hostelmanagement";
	private static final String username = "root";
	private static final String password = "root";
	private static Connection con;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int ch ;
		
		

		do {
			displaymenu();
			System.out.println("enter your choice");
			ch = sc.nextInt();
			switch(ch) {
			case 1:insertion();
			break;
			case 2: deletionbyid();
			break;
			case 3: updation();
			break;
			case 4: getall();
			break;
			case 5: getbyid();
			break;
			case 6: System.exit(0);
			break;
			default:System.out.println("invalid");
				
			
			
			}
			
		} while (ch>0);
	}
	private static void getbyid() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			String sql = "select * from rooms where room_id = ?";
			pmst = con.prepareStatement(sql);
			System.out.println("Enter the id");
			pmst.setInt(1, sc.nextInt());
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				System.out.println("room_id:"+rs.getInt("room_id"));
				System.out.println("room_capacity:"+rs.getInt("room_capacity"));
				System.out.println("current_occupancy:"+rs.getBoolean("current_occupancy"));
			}
			pmst.close();
			con.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	private static void getall() {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			String sql = "select * from rooms";
			pmst = con.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
		
			while(rs.next()) {
				System.out.println("room_id:"+rs.getInt("room_id"));
				System.out.println("room_capacity:"+rs.getInt("room_capacity"));
				System.out.println("current_occupancy:"+rs.getBoolean("current_occupancy"));
			}
			
		
			pmst.close();
			con.close();
		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	private static void updation() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			String sql = "update rooms set room_capacity = ? where room_id = ?";
			pmst = con.prepareStatement(sql);
			System.out.println("Enter the room capacity");
			pmst.setInt(1, sc.nextInt());
			System.out.println("Enter the id");
			pmst.setInt(2, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("updation is done");
			}else {
				System.out.println("updation not done");
			}
			pmst.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	private static void deletionbyid() {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			String sql = "delete from rooms where room_id = ?";
			pmst = con.prepareStatement(sql);
			System.out.println("Enter the id");
			pmst.setInt(1, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("data is deleted");
			}else {
				System.out.println("data is not deleted");
			}
			pmst.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		
	}
	private static void insertion() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			String sql = "insert into rooms(room_capacity,current_occupancy) values(?,?)";
			pmst=con.prepareStatement(sql);
			System.out.println("Enter the room capacity");
			pmst.setInt(1, sc.nextInt());
			System.out.println("Enter the current occupancy");
			pmst.setBoolean(2, sc.nextBoolean());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("data is inserted");
			}
			else {
				System.out.println("data is not inserted");
			}
			pmst.close();
			con.close();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	private static void displaymenu() {
		// TODO Auto-generated method stub
		System.out.println("\t1.adding rooms");
		System.out.println("\t2.deleting rooms");
		System.out.println("\t3.room upgradation");
		System.out.println("\t4.show all rooms");
		System.out.println("\t5.show available rooms");
		System.out.println("\t6.exit");
		
		
	}

}
