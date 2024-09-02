package entidy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.Movimento;

public class player extends Entidy {
    GamePanel gp;
    Movimento KeyM;

    public player(GamePanel P_gp, Movimento P_KeyM) {
        this.gp = P_gp;
        this.KeyM = P_KeyM;
        setDefaultValues();
        getPlayerImage(); 
    }

    public void setDefaultValues() {
        x = 60;
        y = 60;
        s = 4;
    }

    public void getPlayerImage() {
        try {
            ply = ImageIO.read(getClass().getResourceAsStream("/Player/ply.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (KeyM.upPress) { y = Math.max(y - s, 0);}
        if (KeyM.downPress) { y = Math.min(y + s, 516); }
        if (KeyM.leftPress) { x = Math.max(x - s, 0); }
        if (KeyM.rightPress) { x = Math.min(x + s, 708); }
    }

	public void draw(Graphics2D g2d) {
    	/*g2d.setColor(Color.white);
    	g2d.fillRect(x, y, gp.telaSize, gp.telaSize);*/
		g2d.drawImage(ply, x, y, gp.telaSize, gp.telaSize, null);
	}
}
