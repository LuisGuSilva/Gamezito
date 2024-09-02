package main;
import javax.swing.JFrame;
public class game {
	public static void main(String[] args) {
		JFrame window = new JFrame();
        
        window.setResizable(false);
        window.setTitle("Game");
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.startGameThread();
	}

}
