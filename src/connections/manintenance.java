package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class manintenance {
private static final String  driver = "com.mysql.cj.jdbc.Driver";
private static final String url = "jdbc:mysql://localhost:3306/hostelmanagement";
private static final String  username = "root";
private static final String password = "root";
private static Connection con;
private static PreparedStatement pmst;
public static void main(String[] args) {
	int choice;
	do {
		Scanner sc = new Scanner(System.in);
		displaymenu();
		System.out.println("enter the choice");
		choice = sc.nextInt();
		switch(choice) {
		case 1:insertion();
		break;
		case 2: deletebyid();
		break;
		case 3: updation();
		break;
		case 4: getall();
		break;
		case 5: getbyid();
		break;
		default:
			System.exit(0);
			break;
		}
		
	} while (choice>0);
	
}
private static void getbyid() {
	// TODO Auto-generated method stub
	Scanner Sc = new Scanner(System.in);
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url,username,password);
		String sql = "select * from maintainence where room_id = ?";
		pmst = con.prepareStatement(sql);
		System.out.println("enter the id");
		pmst.setInt(1, Sc.nextInt());
		ResultSet rs  = pmst.executeQuery();
		while(rs.next()) {
			System.out.println("id:"+rs.getInt("id"));
			System.out.println("room_id:"+rs.getInt("room_id"));
			System.out.println("issue:"+rs.getString("issue"));
		}
		pmst.close();
		con.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
}
private static void getall() {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url,username,password);
		String sql = "select * from maintainence";
		pmst = con.prepareStatement(sql);
		ResultSet rs = pmst.executeQuery();
	
		while(rs.next()) {
			System.out.println("id:"+rs.getInt("id"));
			System.out.println("room_id:"+rs.getInt("room_id"));
			System.out.println("issue:"+rs.getString("issue"));
		}
		pmst.close();
		con.close();
	}
		 catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
}
private static void updation() {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url,username,password);
		String sql = "update maintainence  set status = ? where room_id = ?";
		pmst = con.prepareStatement(sql);
		System.out.println("Enter the status");
		pmst.setString(1, sc.next());
		System.out.println("Enter the id");
		pmst.setInt(2, sc.nextInt());
		int i = pmst.executeUpdate();
		if(i>0) {
			System.out.println("Updation is done");
		}else {
			System.out.println("Updation is not done");
		}
		pmst.close();
		con.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}
private static void deletebyid() {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url,username,password);
		String sql = "delete from maintainence where room_id = ?";
		pmst = con.prepareStatement(sql);
		System.out.println("Enter the id");
		pmst.setInt(1, sc.nextInt());
		int i = pmst.executeUpdate();
		if(i>0) {
			System.out.println("Data is Deleted");
		}
		else {
			System.out.println("Data is not deleted");
		}
		pmst.close();
		con.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}
private static void insertion() {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	try {
		Class.forName(driver);
		String url = "jdbc:mysql://localhost:3306/hostelmanagement";
		con = DriverManager.getConnection(url,username,password);
		String sql = "insert into maintainence (id,room_id,issue) values(?,?,?)";
		pmst= con.prepareStatement(sql);
		System.out.println("Enter the id");
		pmst.setInt(1, sc.nextInt());
		System.out.println("Enter the room_id");
		pmst.setInt(2, sc.nextInt());
		System.out.println("Enter the issue");
		pmst.setString(3, sc.next());
		int i = pmst.executeUpdate();
		if(i>0) {
			System.out.println("Data is inserted");
		}
		else {
			System.out.println("Data is not inserted");
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
	System.out.println("\t1.insertion");
	System.out.println("\t2.delete by id");
	System.out.println("\t3.updation");
	System.out.println("\t4.getall");
	System.out.println("\t5.getbyid");
	System.out.println("\t6.exit");
	
}

}
