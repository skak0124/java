import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CustomerTable extends JFrame {

	private static final Object[][] String = null;
	private JPanel contentPane;
	private JTextField search;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerTable frame = new CustomerTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setSize(600, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//String[][] data = Customer.getCustomers();
		String[][] data = { {"1","2","3","4","5"},{"1","2","3","4","5"},{"1","2","3","4","5"} }; // 이차원 배열 5칸
		String[] headers = {"ID", "PASS", "GENDER", "PHONE", "NOTE"}; // 제목
		
		DefaultTableModel model  = new DefaultTableModel(data, headers);
		contentPane.setLayout(null);
		//contentPane.setLayout(null);
		
		
		JTable table = new JTable(model); //데이터는 테이블에 들어갈 내용 , 헤더즈는 제목
		
		table.setRowHeight(30);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 67, 452, 428);
		scrollPane.setFont(new Font("궁서체", Font.BOLD, 14));
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("리프레쉬");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0); //테이블 데이터 모두 삭제
				String[][] data = Customer.getCustomers();
				for (int i = 0; i < data.length; i++) {
					model.addRow(data[i]);
					
				}
			}
		});
		btnNewButton.setBounds(480, 212, 81, 23);
		contentPane.add(btnNewButton);
		
		search = new JTextField(); //검색하는 텍스트필드
		search.addKeyListener(new KeyAdapter() {
					
			@Override
			public void keyReleased(KeyEvent arg0) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
				
			}
		});
		
		
		search.setBounds(12, 10, 328, 48);
		contentPane.add(search);
		search.setColumns(10);
		
		table.addMouseListener(new MouseAdapter() {
				@Override
			public void mouseClicked(MouseEvent e) { //클릭발생했을때 열과 줄의 정보를 출력
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				String[] headers = {"id", "pass", "gender", "phone", "note"};
				if(row >= 0 && col >= 0) {
					//JOptionPane.showMessageDialog(null, row+","+col);
					new Modal(row, headers[col]).setVisible(true);
				}
				
			}
		});
		}
}








