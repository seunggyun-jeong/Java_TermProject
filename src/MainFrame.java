import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



public class MainFrame extends JFrame{
	MainPanel mp = new MainPanel();
	
	
	public MainFrame(){
		setTitle("17155335_모바일소프트웨어전공_정승균_텀프로젝트");
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
		
		for(int i = 0; i < 4; i++) { //나라별 음식 카테고리 생성
			Country[i] = new JMenu(CountryName[i]);
			Country[i].setName(CountryName[i]);
			Country[i].addMouseListener(listener);
			mb.add(Country[i]);
		}
		
		setJMenuBar(mb);
		
	}
//메뉴바의 메뉴를 누르면 선택할 수 있는 메뉴 목록이 바뀜
	class MenuActionListener extends MouseAdapter{

		public void mouseClicked(MouseEvent e) {
			Component menu = e.getComponent();
			String cmd = menu.getName();
			
			
			
			switch(cmd) {
			case "Korean" :
				mp.dp.removeAll();//원래 그려져있던 메뉴들을 지움
				repaint();//다시 그리기
				
				mp.dp.KoreanMenu();//한식 메뉴들 입력
				validate();//보여주기
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
				
				JLabel ready = new JLabel("준비 중 입니다.");
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
