//sql 사용 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Customer {
	public static void main(String[] args) {
		//getConnection();
		//createTable(); //
		//createStudent("김노아무개","웹크롤링학과","1234");
		//createCustomer("jk123", "1234", "남성", "123-1234-2345", "중요한 고객입니다"); //실제 테이블은 만들어져있으므로 만들어져있고 실행만한다.
		//getCustomers();
		
		//login("jk123", "1234"); 
	}
	
	public static void update(int row, String name, String text) {
		try {
			Connection conn = getConnection(); // DB에 연결(접속)하기 CONN이라는 객체에 
			PreparedStatement update = conn.prepareStatement( //변수명 업데이트
					"UPDATE customer SET "+name+" = '"+text+"' WHERE customer_id=?"); //sql에서 사용하는 쿼리문 적는다고 인지하기
			//statement.setString(1, id);
			//statement.setString(2, pass);
			//ResultSet results = statement.executeQuery();		//결과를 원할때.
			
			update.setInt(1, row+1); //업데이트
			update.execute(); //업데이트
			System.out.println("업데이트 되었습니다.!");
		} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void login(String id, String pass) { //id와 pass가 매개변수로 login으로 들어간다.
		try {
			Connection conn = getConnection(); // DB에 연결(접속)하기 CONN이라는 객체에 
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM customer WHERE id=? and pass=?");
			statement.setString(1, id);
			statement.setString(2, pass);
			ResultSet results = statement.executeQuery();		//결과를 원할때.
			if(results.next()) {
				JOptionPane.showMessageDialog(null, "로그인 성공!");
				
			}else
				JOptionPane.showMessageDialog(null, "아이디나 패스워드가 틀립니다.");
	
				
	} catch (Exception e) {
		e.printStackTrace();
	}
	}



	public static String[][] getCustomers() { //커스터머 데이터를 전부 가져감
		try {
			Connection conn = getConnection(); // DB에 연결(접속)하기 CONN이라는 객체에 
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM customer");	ResultSet results = statement.executeQuery(); //결과를 원할때. 
			ArrayList<String[]> list = new ArrayList<String[]>();
			
			while(results.next()) {
				list.add(new String[] {
					results.getString("id"),
					results.getString("pass"),
					results.getString("gender"),
					results.getString("phone"),
					results.getString("note"),
				});
			}
							
			//System.out.println("손님이 저장되었습니다.");
			System.out.println("검색되었습니다.");
			String[][] arr = new String[list.size()][5];
			
			return list.toArray(arr);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static void createCustomer(String id, String pass, String gender, String phone, String note) {
		try {
			Connection conn = getConnection(); // DB에 연결하기 CONN이라는 객체에 
			PreparedStatement insert = conn.prepareStatement(
					"INSERT INTO customer(id,pass,gender,phone,note)"
					+ "VALUES('"+id+"','"+pass+"','"+gender+"','"+phone+"','"+note+"')");
					insert.execute(); //execute 결과필요하지 않을때 .
					System.out.println("손님이 저장되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public static void createTable() {    // sql테이블 만들기 위한/  테이블만들기
		 try {
				Connection conn = getConnection();
				PreparedStatement create = conn.prepareStatement(
						"CREATE TABLE IF NOT EXISTS "
						+"customer(customer_id int NOT NULL AUTO_INCREMENT,"
						+"id varChar(225),"
						+"pass varChar(225),"
						+"gender varChar(225),"
						+"phone varChar(225),"
						+"note varChar(225),"
						+"PRIMARY KEY(customer_id))");						
				create.execute();
				System.out.println("테이블을 만들었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				
			}	
			}
	 
	 
	
	public static void createStudent(String name, String dept, String id) {
	try {
		Connection conn = getConnection();
		PreparedStatement insert = conn.prepareStatement(
				"INSERT INTO student( name, dept, id) " + "VALUES ('"+name+"','"+dept+"','"+id+"')");
		insert.execute();
		System.out.println("저장했습니다.");
	} catch (Exception e) {
		e.printStackTrace(); 
		
	}	
	}
	public static Connection getConnection() { //DB연결하는 
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root"; 
		String pass = "003100"; //내가 지정한 패스워드 등록
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,pass);
			System.out.println("DB 연결 완료!");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
