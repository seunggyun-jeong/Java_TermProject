import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



public class MainFrame extends JFrame{
	MainPanel mp = new MainPanel();
	
	
	public MainFrame(){
		setTitle("17155335_����ϼ���Ʈ��������_���±�_��������Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mp);
		
		createMenuBar();
		
		setSize(510,800);
		setVisible(true);
	}
	
//////////////////////////////////MenuBar///////////////////////////////////	
	public void createMenuBar() {
		JMenuBar mb = new JMenuBar();
		
		JMenu[] Country = new JMenu[4];
		String[] CountryName = {"Korean", "Chinese", "Japanese", "Western"};
		
		MenuActionListener listener = new MenuActionListener();
		
		for(int i = 0; i < 4; i++) { //���� ���� ī�װ� ����
			Country[i] = new JMenu(CountryName[i]);
			Country[i].setName(CountryName[i]);
			Country[i].addMouseListener(listener);
			mb.add(Country[i]);
		}
		
		setJMenuBar(mb);
		
	}
//�޴����� �޴��� ������ ������ �� �ִ� �޴� ����� �ٲ�
	class MenuActionListener extends MouseAdapter{

		public void mouseClicked(MouseEvent e) {
			Component menu = e.getComponent();
			String cmd = menu.getName();
			
			
			
			switch(cmd) {
			case "Korean" :
				mp.dp.removeAll();//���� �׷����ִ� �޴����� ����
				repaint();//�ٽ� �׸���
				
				mp.dp.KoreanMenu();//�ѽ� �޴��� �Է�
				validate();//�����ֱ�
				break;
			case "Japanese":
				mp.dp.removeAll();
				repaint();
				
				mp.dp.JapeneseMenu();
				validate();
				break;
			case "Chinese" :
				mp.dp.removeAll();
				repaint();
				
				mp.dp.ChineseMenu();
				validate();
				break;
			case "Western" :
				mp.dp.removeAll();
				repaint();
				
				JLabel ready = new JLabel("�غ� �� �Դϴ�.");
				ready.setSize(500, 500);
				ready.setFont(new Font("", Font.BOLD, 60));
				mp.dp.add(ready);
				validate();
				break;
			}
		}
		
	}

	
	public static void main(String[] args) {
		new MainFrame();

	}

}
