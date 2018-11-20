package fullscreen;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

public class EntryPoint extends JFrame{

	public static void main(String[] args) {
                //szélesség, magasság, színmélység, frissítési ráta amit nem tudunk
		DisplayMode dm=new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		EntryPoint b=new EntryPoint();
		b.run(dm);
	}
	
	public void run(DisplayMode dm){
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setFont(new Font("Times New Roman", Font.PLAIN,27));
		FullScreen fs=new FullScreen();
		try{
			fs.setFullScreen(dm, this);
			try{
				Thread.sleep(5000);
                        }catch(InterruptedException ex){}
		}finally{
			fs.restore();
		}
		
	}
	
	public void paint(Graphics g){
		g.drawString("Megcsináltad!", 200, 200);
	}
        
    }