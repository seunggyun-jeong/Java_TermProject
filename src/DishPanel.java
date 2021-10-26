import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DishPanel extends ShoppingBagPanel {
	dishActionListener dishAL = new dishActionListener();
	String [] ChName = {"자장면", "짬뽕", "볶음밥", "탕수육", "마라탕","양장피", "유산슬", "마파두부", "공기밥"};
	String [] KoName = {"국밥", "김치찌개", "된장찌개", "공기밥", "제육볶음","소불고기", "안동찜닭", "잡채", "부추전"};
	String [] JpName = {"돈가스", "우동", "소바", "라멘", "가라아게","모듬초밥", "규동", "연어사시미", "가츠나베"};
	
	int [] ChPrice = {5000, 6000, 7000, 12900, 8000, 14900, 12500, 4400, 1000};
	int [] KoPrice = {5900, 6000, 6000, 1000, 7000, 8000, 10000, 5000, 4000};
	int [] JpPrice = {7900, 3900, 5500, 7500, 9900, 11000, 7500, 20000, 8500};
	
	dishCountDialog dialog = new dishCountDialog(new JFrame());
//////////////////////한식////////////////////////////////////
	public void KoreanMenu() {
			JButton [] KoButton = new JButton[9];

			ImageIcon [] KoImage = {
					new ImageIcon("images/koimg/image01.png"),
					new ImageIcon("images/koimg/image02.png"),
					new ImageIcon("images/koimg/image03.png"),
					new ImageIcon("images/koimg/image04.png"),
					new ImageIcon("images/koimg/image05.png"),
					new ImageIcon("images/koimg/image06.png"),
					new ImageIcon("images/koimg/image07.png"),
					new ImageIcon("images/koimg/image08.png"),
					new ImageIcon("images/koimg/image09.png")
			};
			setBackground(Color.white);
			setLayout(new GridLayout(3,3,10,10));
			for(int i = 0; i < 9; i++) {
				KoButton[i] = new JButton(KoImage[i]);
				KoButton[i].setPreferredSize(new Dimension(150,150));
				KoButton[i].setName(KoName[i]);
				KoButton[i].addMouseListener(dishAL);
				add(KoButton[i]);
			}	
	}
//////////////////////일식////////////////////////////////////
	public void JapeneseMenu() {
		JButton [] JpButton = new JButton[9];

		ImageIcon [] JpImage = {
				new ImageIcon("images/jpimg/image01.png"),
				new ImageIcon("images/jpimg/image02.png"),
				new ImageIcon("images/jpimg/image03.png"),
				new ImageIcon("images/jpimg/image04.png"),
				new ImageIcon("images/jpimg/image05.png"),
				new ImageIcon("images/jpimg/image06.png"),
				new ImageIcon("images/jpimg/image07.png"),
				new ImageIcon("images/jpimg/image08.png"),
				new ImageIcon("images/jpimg/image09.png")
		};
		setBackground(Color.white);
		setLayout(new GridLayout(3,3,10,10));
		for(int i = 0; i < 9; i++) {
			JpButton[i] = new JButton(JpImage[i]);
			JpButton[i].setPreferredSize(new Dimension(150,150));
			JpButton[i].setName(JpName[i]);
			JpButton[i].addMouseListener(dishAL);
			add(JpButton[i]);
		}	
	}
//////////////////////중식////////////////////////////////////
	public void ChineseMenu() {
		JButton [] ChButton = new JButton[9];
		
		ImageIcon [] ChImage = {
				new ImageIcon("images/chimg/image01.png"),
				new ImageIcon("images/chimg/image02.png"),
				new ImageIcon("images/chimg/image03.png"),
				new ImageIcon("images/chimg/image04.png"),
				new ImageIcon("images/chimg/image05.png"),
				new ImageIcon("images/chimg/image06.png"),
				new ImageIcon("images/chimg/image07.png"),
				new ImageIcon("images/chimg/image08.png"),
				new ImageIcon("images/chimg/image09.png")
		};
		setBackground(Color.white);
		setLayout(new GridLayout(3,3,10,10));
		for(int i = 0; i < 9; i++) {
			ChButton[i] = new JButton(ChImage[i]);
			ChButton[i].setPreferredSize(new Dimension(150,150));
			ChButton[i].setName(ChName[i]);
			ChButton[i].addMouseListener(dishAL);
			add(ChButton[i]);
		}	
	}
//////////////버튼 마우스리스너 지정/////////////////////////////////////////////////
	class dishActionListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			Component Btn = e.getComponent();
			String src = Btn.getName();
			
			for(int i = 0; i < 9; i++) {
				if(src.equals(ChName[i])) {
					try {
						dialog.setVisible(true);
						addDB(src, dialog.getInput(), ChPrice[i]);
					} catch(NumberFormatException l) {
						dialog.tf.setText("");
					}

				}
				else if (src.equals(KoName[i])){
					try {
						dialog.setVisible(true);
						addDB(src, dialog.getInput(), KoPrice[i]);
					} catch(NumberFormatException l) {
						dialog.tf.setText("");
					}
				}
				else if (src.equals(JpName[i])) {
					try {
						dialog.setVisible(true);
						addDB(src, dialog.getInput(), JpPrice[i]);
					}catch(NumberFormatException l) {
						dialog.tf.setText("");
					}
				}
			}
		}
		
		void addDB(String name, int i, int price) {
			allprice = price * i;
			selectedName = name;
			count = i;
			
			addTable();
			
			dialog.tf.setText("");
		}
		
		
	}
	
	class dishCountDialog extends JDialog{
		private JTextField tf = new JTextField(10);
		private JButton okButton =new JButton("Ok"); 
		
		public dishCountDialog(JFrame frame) {
			super(frame, "수량 선택", true);
			setLayout(new FlowLayout());
			add(tf);
			add(okButton);
			setSize(200, 100);
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
		
		public int getInput() {
			return Integer.parseInt(tf.getText());
		}
		
		
	}
	
	public DishPanel(){
		removeAll();
		repaint();
		KoreanMenu();
	}
}
