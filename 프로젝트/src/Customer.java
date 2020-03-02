//sql ��� 
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
		//createStudent("���ƹ���","��ũ�Ѹ��а�","1234");
		//createCustomer("jk123", "1234", "����", "123-1234-2345", "�߿��� ���Դϴ�"); //���� ���̺��� ������������Ƿ� ��������ְ� ���ุ�Ѵ�.
		//getCustomers();
		
		//login("jk123", "1234"); 
	}
	
	public static void update(int row, String name, String text) {
		try {
			Connection conn = getConnection(); // DB�� ����(����)�ϱ� CONN�̶�� ��ü�� 
			PreparedStatement update = conn.prepareStatement( //������ ������Ʈ
					"UPDATE customer SET "+name+" = '"+text+"' WHERE customer_id=?"); //sql���� ����ϴ� ������ ���´ٰ� �����ϱ�
			//statement.setString(1, id);
			//statement.setString(2, pass);
			//ResultSet results = statement.executeQuery();		//����� ���Ҷ�.
			
			update.setInt(1, row+1); //������Ʈ
			update.execute(); //������Ʈ
			System.out.println("������Ʈ �Ǿ����ϴ�.!");
		} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void login(String id, String pass) { //id�� pass�� �Ű������� login���� ����.
		try {
			Connection conn = getConnection(); // DB�� ����(����)�ϱ� CONN�̶�� ��ü�� 
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM customer WHERE id=? and pass=?");
			statement.setString(1, id);
			statement.setString(2, pass);
			ResultSet results = statement.executeQuery();		//����� ���Ҷ�.
			if(results.next()) {
				JOptionPane.showMessageDialog(null, "�α��� ����!");
				
			}else
				JOptionPane.showMessageDialog(null, "���̵� �н����尡 Ʋ���ϴ�.");
	
				
	} catch (Exception e) {
		e.printStackTrace();
	}
	}



	public static String[][] getCustomers() { //Ŀ���͸� �����͸� ���� ������
		try {
			Connection conn = getConnection(); // DB�� ����(����)�ϱ� CONN�̶�� ��ü�� 
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM customer");	ResultSet results = statement.executeQuery(); //����� ���Ҷ�. 
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
							
			//System.out.println("�մ��� ����Ǿ����ϴ�.");
			System.out.println("�˻��Ǿ����ϴ�.");
			String[][] arr = new String[list.size()][5];
			
			return list.toArray(arr);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static void createCustomer(String id, String pass, String gender, String phone, String note) {
		try {
			Connection conn = getConnection(); // DB�� �����ϱ� CONN�̶�� ��ü�� 
			PreparedStatement insert = conn.prepareStatement(
					"INSERT INTO customer(id,pass,gender,phone,note)"
					+ "VALUES('"+id+"','"+pass+"','"+gender+"','"+phone+"','"+note+"')");
					insert.execute(); //execute ����ʿ����� ������ .
					System.out.println("�մ��� ����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public static void createTable() {    // sql���̺� ����� ����/  ���̺����
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
				System.out.println("���̺��� ��������ϴ�.");
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
		System.out.println("�����߽��ϴ�.");
	} catch (Exception e) {
		e.printStackTrace(); 
		
	}	
	}
	public static Connection getConnection() { //DB�����ϴ� 
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root"; 
		String pass = "003100"; //���� ������ �н����� ���
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,pass);
			System.out.println("DB ���� �Ϸ�!");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
