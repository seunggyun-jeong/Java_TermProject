import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
	DishPanel dp = new DishPanel();
	ShoppingBagPanel sbp = new ShoppingBagPanel();
	
	public MainPanel() {
		
		setLayout(null);
		setBackground(Color.white);
		
		add(dp);
		dp.setSize(500, 500);
		dp.setLocation(0, 0);
		
		add(sbp);
		sbp.setLocation(5,500);
		sbp.setSize(500,230);
		
	}
	

}