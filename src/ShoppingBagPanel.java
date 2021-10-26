import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class ShoppingBagPanel extends JPanel {
	private static JTable table;
	private JScrollPane scrolledTable;
	private static JLabel printPrice;
	
	private JButton payBtn = new JButton("���� �ϱ�");
	payBtnListener payBtnListener = new payBtnListener(); 
	delBtnListener delBtnListener = new delBtnListener();
	private JButton delBtn = new JButton("����");
	
	
	static int allprice = 0;
	static String selectedName = null;
	static int count = 0;
	static int sum = 0;
	
	
	public ShoppingBagPanel() {
		setBackground(Color.white);
		setLayout(null);
		
		String header[] = {"��ǰ �̸�", "��ǰ ����", "����"};
		String data [][] = null;
		DefaultTableModel model = new DefaultTableModel(data,header) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};//�� ���� �Ұ� ����

		
		
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);//JTable �� ���� ����
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		scrolledTable=new JScrollPane(table); //��ǰ�� ������ ��ũ�� �Ͽ� Ȯ���� �� �ֵ��� ��ũ���� ����
		scrolledTable.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		scrolledTable.setBounds(new Rectangle(0,10,300,150));//���̺� ��ġ ����
		
		add(scrolledTable);
		
		printPrice = new JLabel("�� ���� : 0 ��");
		printPrice.setFont(new Font("Basic", Font.CENTER_BASELINE, 20));
		printPrice.setBounds(new Rectangle(0,150,300,80));
		add(printPrice);
		
		payBtn.setBounds(new Rectangle(330, 10, 150, 100));
		payBtn.addMouseListener(payBtnListener);
		
		payBtn.setBackground(Color.yellow);
		payBtn.setFont(new Font("Basic", Font.BOLD, 25));
		add(payBtn);
		
		delBtn.setBounds(new Rectangle(330, 120, 150, 100));
		delBtn.setBackground(Color.red);
		delBtn.setFont(new Font("Basic", Font.BOLD, 30));
		delBtn.addMouseListener(delBtnListener);
		add(delBtn);
		
	}
	
	static void addTable() {//��ٱ��Ͽ� �߰�
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		String []record=new String[3];
		
		record[0] = selectedName;
		record[1] = Integer.toString(count);
		record[2] = Integer.toString(allprice) + " ��";
		
		model.addRow(record);
		
		for(int i = 0; i < 3; i++) {
			record[i]="";
		}
		
		sum += allprice;//�� ���� ����
		printPrice.setText("�� ���� : " + sum + " ��");
		
	}
	
	class delBtnListener extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
			
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			int selectedRow = table.getSelectedRow();
			
			if(selectedRow==-1)return;
			
			String obj = (String)model.getValueAt(selectedRow, 2);
			StringTokenizer st =new StringTokenizer(obj, " ");
			obj = st.nextToken();
			

			sum = sum - Integer.parseInt(obj);
			printPrice.setText("�� ���� : " + sum + " ��");
			model.removeRow(selectedRow);
			
		}
	}
	
	class payBtnListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			
			JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "���� �Ϸ�", JOptionPane.INFORMATION_MESSAGE);
			
			sum = 0;
			printPrice.setText("�� ���� : " + sum + " ��");
			model.setRowCount(0);
			
		}
	}
	

}
