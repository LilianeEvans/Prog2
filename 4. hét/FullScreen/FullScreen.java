package fullscreen;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import javax.swing.JFrame;

public class FullScreen {
      GraphicsDevice  vc;
	public FullScreen(){
		  GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		  vc=ge.getDefaultScreenDevice();
	}
	
	
	public void setFullScreen(DisplayMode dm, JFrame frame){
		frame.setUndecorated(true);
		frame.setResizable(false);
		vc.setFullScreenWindow(frame);		
	}
	
	public void restore(){
		Window w=vc.getFullScreenWindow();
		if(w!=null){
			w.dispose();
		}
		vc.setFullScreenWindow(null);
	}
}