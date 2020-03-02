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

//	private JLabel la1;  // ���̺� ��ü ������ ���� ������� ����Ҽ� ����.... 
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
		frame.setLocationRelativeTo(null); //��� ��ġ 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImgPanel panel = new ImgPanel(new ImageIcon("C:\\�ڹ��н�\\Ŀ��.png").getImage()); //�̹��� ��θ� �����η� ����
		frame.getContentPane().add(panel); //�̹����г� ����¹�. �г����� �α���â���� ������ �ϱ� ������ 
		 
		
		/*la1*/ JLabel la1 = new JLabel("\uB85C\uADF8\uC778\uD398\uC774\uC9C0");
		la1.setOpaque(true);
		la1.setBackground(Color.WHITE);
		la1.setForeground(Color.BLUE);
		la1.setHorizontalAlignment(SwingConstants.CENTER);
		la1.setFont(new Font("����", Font.BOLD, 17));
		la1.setBounds(12, 301, 118, 43);
		panel.add(la1);
		
		/*la2*/ JLabel la2 = new JLabel("\uC544\uC774\uB514 :");
		la2.setForeground(Color.WHITE);
		la2.setHorizontalAlignment(SwingConstants.CENTER);
		la2.setFont(new Font("����", Font.BOLD, 15));
		la2.setBounds(0, 354, 88, 35);
		panel.add(la2);
		
		/*la3*/ JLabel la3 = new JLabel("\uBE44\uBC00\uBC88\uD638 : ");
		la3.setForeground(Color.WHITE);
		la3.setHorizontalAlignment(SwingConstants.CENTER);
		la3.setFont(new Font("����", Font.BOLD, 15));
		la3.setBounds(0, 399, 88, 35);
		panel.add(la3);
		
		id = new JTextField(); //�ؽ�Ʈ�ʵ� �̸� ����
		id.setBounds(81, 361, 101, 21);
		panel.add(id);
		id.setColumns(10);
		
		pass = new JPasswordField(); //�н������ʵ� �̸� ����2
		pass.setBounds(81, 406, 101, 21);
		panel.add(pass);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer.login(id.getText(),pass.getText()); // �޾ƿ��� ������. id��  pass �ؽ�Ʈ�ʵ�, �н������ʵ� �̸� ����
			} //Ŀ���͸� Ŭ������ �α��� �޼ҵ� �ҷ�����
		});
		btnNewButton.setFont(new Font("�ü�ü", Font.BOLD, 16));
		btnNewButton.setBounds(194, 360, 96, 67);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton_1.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\10\uC7A5_\uC774\uBCA4\uD2B8\uCC98\uB9AC\\\uD504\uB85C\uC81D\uD2B8\\image\\Ok-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose(); //�������� ������ ���� ������â�� ����.
				new Join().setVisible(true); //ȸ������ �������� ������ ��Ÿ��.  Join�� ������ �����̸�. �� ȭ��(����������) ��ȯ�ȴٴ� �ǹ̴�.
			}
		});
		
		btnNewButton_1.setFont(new Font("�ü�ü", Font.BOLD, 10));
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


