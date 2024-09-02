
	package main;

	import javax.swing.JPanel;

import Tile.TileManeger;
import entidy.player;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

	public class GamePanel extends JPanel implements Runnable {
	    // SCREEN 
	    final int INI_TelaSize = 16;
	    final int scale = 3;
	    public final int telaSize = INI_TelaSize * scale; // 48 x 48
	    public final int maxScreenCol = 16;
	    public final int maxScreenRow = 12;
	    final int Screencmp = telaSize * maxScreenCol; // 768 
	    final int Screenalt = telaSize * maxScreenRow; // 576 
	    
	    Movimento keyM = new Movimento();
	    Thread gameThread;
	    player Py = new player(this,keyM); 
	    
	    int FPS = 60;
	    //player settings
	    TileManeger TM_tile = new TileManeger(this);
	    int p_x = 60;
	    int p_y = 60;
	    int s= 3;
	    
	    public GamePanel() {
	        this.setPreferredSize(new Dimension(Screencmp, Screenalt));
	        this.setBackground(Color.black);
	        this.setDoubleBuffered(true);
	        this.addKeyListener(keyM);
	        this.setFocusable(true);
	    }


		public void startGameThread() {
	        gameThread = new Thread(this);
	        gameThread.start(); 
	    }

	    @Override
	    public void run() {
	    	double Draw = 1000000000/FPS;
	    	double nextDraw = System.nanoTime() + Draw;
	    	
	    	while( gameThread != null) {  
	    	   update();
	    	   repaint();
	    	   try {
	    		double timeAtual =nextDraw - System.nanoTime();
				timeAtual = timeAtual/1000000;
				
				if(timeAtual < 0) { timeAtual = 0;}
	
	    		Thread.sleep((long) timeAtual);
	    		nextDraw += Draw;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    	}
	    }
	    public void update() {
	    	Py.update();
	    }
	    
	    public void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	Graphics2D g2d = (Graphics2D)g;
	    	
	    	TM_tile.draw(g2d);	    	
	    	Py.draw(g2d);
	    	
	    	g2d.dispose();
	    }
	}

