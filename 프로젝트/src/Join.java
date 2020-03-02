import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Join extends JFrame { 

	private JPanel contentPane;
	private JTextField id;
	private JTextField pass;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join frame = new Join();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); //프레임에 대한 . 가운데 정렬
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400); //좌표,좌표,사이즈,사이즈
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
				
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 584, 361);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785 \uD398\uC774\uC9C0");
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("궁서체", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 10, 477, 55);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setFont(new Font("궁서체", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setBounds(52, 94, 57, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("궁서체", Font.PLAIN, 12));
		lblNewLabel_1_1.setBackground(Color.YELLOW);
		lblNewLabel_1_1.setBounds(52, 164, 57, 36);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uC131\uBCC4");
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("궁서체", Font.PLAIN, 12));
		lblNewLabel_1_2.setBackground(Color.YELLOW);
		lblNewLabel_1_2.setBounds(52, 238, 57, 36);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_1_3.setOpaque(true);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("궁서체", Font.PLAIN, 12));
		lblNewLabel_1_3.setBackground(Color.YELLOW);
		lblNewLabel_1_3.setBounds(265, 94, 57, 36);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("\uD2B9\uC774\uC0AC\uD56D");
		lblNewLabel_1_4.setOpaque(true);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("궁서체", Font.PLAIN, 12));
		lblNewLabel_1_4.setBackground(Color.YELLOW);
		lblNewLabel_1_4.setBounds(265, 164, 57, 36);
		panel.add(lblNewLabel_1_4);
		
		id = new JTextField();
		id.setFont(new Font("바탕", Font.PLAIN, 18));
		id.setBounds(121, 95, 132, 36);
		panel.add(id);
		id.setColumns(10);
		
		JTextArea note = new JTextArea();
		note.setBorder(new LineBorder(Color.BLACK, 3));
		note.setFont(new Font("바탕", Font.PLAIN, 16));
		note.setBounds(334, 164, 132, 110);
		panel.add(note);
		
		
		String[] combo = { "남성" , "여성" };
		JComboBox gender = new JComboBox(combo); //문자열 넣을 수 있게 되어있음
		gender.setFont(new Font("바탕체", Font.BOLD, 18));
		gender.setBounds(121, 238, 132, 36);
		panel.add(gender);
		
		pass = new JTextField();
		pass.setFont(new Font("바탕", Font.PLAIN, 18));
		pass.setColumns(10);
		pass.setBounds(121, 164, 132, 36);
		panel.add(pass);
		
		phone = new JTextField();
		phone.setFont(new Font("바탕", Font.PLAIN, 18));
		phone.setColumns(10);
		phone.setBounds(334, 94, 132, 36);
		panel.add(phone);
		
		JButton btnJoin = new JButton("\uD68C\uC6D0\uAC00\uC785\uC644\uB8CC"); //회원가입완료 버튼에 sql문 연결
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idTxt = id.getText();
				String passTxt = pass.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String phoneTxt = phone.getText();
				String noteTxt = note.getText();
				Customer.createCustomer(idTxt, passTxt, genderTxt, phoneTxt, noteTxt );
				JOptionPane.showMessageDialog(null, "성공적으로 저장되었습니다.");
				dispose();
				// new 다른프레임().setVisible(true);
			}
		});
		btnJoin.setBackground(Color.WHITE);
		btnJoin.setFont(new Font("궁서", Font.BOLD, 20));
		btnJoin.setBounds(195, 284, 207, 55);
		panel.add(btnJoin);
	}
}
