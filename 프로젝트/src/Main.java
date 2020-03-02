import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JTextField id;
	private JPasswordField pass;

//	private JLabel la1;  // 레이블 객체 많을때 순서 상관없이 사용할수 있음.... 
//	private JLabel la2;
//	private JLabel la3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 690, 499);
		frame.setLocationRelativeTo(null); //가운데 위치 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImgPanel panel = new ImgPanel(new ImageIcon("C:\\자바학습\\커리.png").getImage()); //이미지 경로를 절대경로로 간다
		frame.getContentPane().add(panel); //이미지패널 만드는법. 패널위에 로그인창등을 보여야 하기 때문에 
		 
		
		/*la1*/ JLabel la1 = new JLabel("\uB85C\uADF8\uC778\uD398\uC774\uC9C0");
		la1.setOpaque(true);
		la1.setBackground(Color.WHITE);
		la1.setForeground(Color.BLUE);
		la1.setHorizontalAlignment(SwingConstants.CENTER);
		la1.setFont(new Font("굴림", Font.BOLD, 17));
		la1.setBounds(12, 301, 118, 43);
		panel.add(la1);
		
		/*la2*/ JLabel la2 = new JLabel("\uC544\uC774\uB514 :");
		la2.setForeground(Color.WHITE);
		la2.setHorizontalAlignment(SwingConstants.CENTER);
		la2.setFont(new Font("굴림", Font.BOLD, 15));
		la2.setBounds(0, 354, 88, 35);
		panel.add(la2);
		
		/*la3*/ JLabel la3 = new JLabel("\uBE44\uBC00\uBC88\uD638 : ");
		la3.setForeground(Color.WHITE);
		la3.setHorizontalAlignment(SwingConstants.CENTER);
		la3.setFont(new Font("굴림", Font.BOLD, 15));
		la3.setBounds(0, 399, 88, 35);
		panel.add(la3);
		
		id = new JTextField(); //텍스트필드 이름 지정
		id.setBounds(81, 361, 101, 21);
		panel.add(id);
		id.setColumns(10);
		
		pass = new JPasswordField(); //패스워드필드 이름 지정2
		pass.setBounds(81, 406, 101, 21);
		panel.add(pass);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer.login(id.getText(),pass.getText()); // 받아오기 때문에. id랑  pass 텍스트필드, 패스워드필드 이름 지정
			} //커스터머 클래스의 로그인 메소드 불러오기
		});
		btnNewButton.setFont(new Font("궁서체", Font.BOLD, 16));
		btnNewButton.setBounds(194, 360, 96, 67);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton_1.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\10\uC7A5_\uC774\uBCA4\uD2B8\uCC98\uB9AC\\\uD504\uB85C\uC81D\uD2B8\\image\\Ok-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose(); //프레임이 꺼지고 다음 프레임창이 켜짐.
				new Join().setVisible(true); //회원가입 페이지로 프레임 나타남.  Join은 프레임 조인이름. 저 화면(프레임으로) 전환된다는 의미다.
			}
		});
		
		btnNewButton_1.setFont(new Font("궁서체", Font.BOLD, 10));
		btnNewButton_1.setBounds(302, 360, 114, 67);
		panel.add(btnNewButton_1);
		
		JButton movebtn1 = new JButton("\uC18C\uAC1C\uAE00");
		movebtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login().setVisible(true);
			}
		});
		movebtn1.setBounds(255, 451, 88, 23);
		panel.add(movebtn1);
			
		
		frame.pack();
			
		
		
	}
}
class ImgPanel extends JPanel{
	private Image img;
	
	public ImgPanel(Image img){
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
		
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, null);
	}

}


