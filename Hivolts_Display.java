import javax.swing.*;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import static java.awt.GraphicsDevice.WindowTranslucency;
//import com.sun.awt.AWTUtilities;
public class Hivolts_Display {

	public static void main(String[] args) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();

		if(!gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT)){


			System.err.println("Translucency is not supported");
			System.exit(0);
		}
	
		JFrame.setDefaultLookAndFeelDecorated(true);

		SwingUtilities.invokeLater(new Runnable() {
		       	public void run(){
				showGUI();
			}});
		

	}
	
	private static void showGUI(){

		HivoltsFrame f = new HivoltsFrame();
		f.setSize(64*12,64*12);

		f.setUndecorated(true);
		f.setBackground(new Color(1f,1f,1f,1.0f));
		f.setVisible(true);
		
	}
}


class HivoltsFrame extends JFrame{

	Grid hivoltsgrid = new Grid(12);
	public	HivoltsFrame(){

		
		super();

	}


	public void update(Graphics g){
		
		setBackground(new Color(0f,0f,0f,0.0f));
		paint(g);
	}
	public void paint(Graphics g){

		
		hivoltsgrid.drawAll(g);

		repaint();
		
	}		
}

