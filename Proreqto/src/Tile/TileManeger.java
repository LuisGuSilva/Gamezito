package Tile;

import main.GamePanel;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TileManeger {
    GamePanel gp;
    tile[] tile;
    public TileManeger(GamePanel gp){
        this.gp = gp;
        tile = new tile[10];
        getTileImage();
    }
    public void getTileImage(){
    	try {
    		tile[0] = new tile();
    		tile[0].img = ImageIO.read(getClass().getResourceAsStream("/Tiles/grama.png"));
    		tile[1] = new tile();
    		tile[1].img = ImageIO.read(getClass().getResourceAsStream("/Tiles/tijolo.png"));
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    public void draw(Graphics2D g2d) {
    	/*g2d.drawImage(tile[0].img, 0, 0, gp.telaSize, gp.telaSize, null);
    	g2d.drawImage(tile[1].img, 60, 0, gp.telaSize, gp.telaSize, null);*/
    	int col = 0, lar = 0, x = 0, y = 0;
    	while(col < gp.maxScreenCol && lar < gp.maxScreenRow) {
    		g2d.drawImage(tile[0].img, x, y, gp.telaSize, gp.telaSize, null);
    		col++; x+= gp.telaSize;
    		
    		if(col == gp.maxScreenCol) {
    			col = 0;
    			x = 0;
    			lar++;
    			y+= gp.telaSize;
    		}
    	}
    }
}
