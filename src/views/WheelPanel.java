package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class WheelPanel extends JPanel{
	
	private static final int INTER_FRAME_DELAY = 1000 / 60;
	private BufferedImage img = null;
	private GUICallback callback;
	
	public WheelPanel(GUICallback callback){
		
		this.callback = callback;
		
		try {
		    img = ImageIO.read(new File("src/images/wheel.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}

	      // add a timer that fires at a particular interval
	      new Timer(INTER_FRAME_DELAY, new ActionListener()
	      {
	         public void actionPerformed(ActionEvent e)
	         {
	            // calls paintComponent()
	            repaint();
	         }
	      }).start();
	   }
	
	
	public void paintComponent(Graphics d)
	   {

		super.paintComponent(d);
		
		//SLOT MATHEMATICS
	      
	      // this gets the height and width of the JPanel
	      int width = getWidth();
	      int height = getHeight();
	      
	      // this just initializes the height and width integers for the drawn wheel.
	      int drawHeight;
	      int drawWidth;
	      
	      //this if else statement makes sure that the image stays square as well as makes sure that it stays within the boundaries of the JPanel and sizes accordingly
	      if (width <= height) {
	    	  
	    	  drawHeight = 	width;
	    	  drawWidth = width;
	      }
	      
	      else
	    	  
	    	  {
	    		  drawHeight = height;
	    		  drawWidth = height;
	    		  
	    	  }
	      
	      // this is the math behind setting where the drawing has to be positioned according to the size of the JPanel and also centers it with relevance to the size of the wheel
	      int widthPos = (width/2) - drawWidth/2;
	      int heightPos = (height/2) - drawHeight/2;
	      
	      // get Radius's
	      
	      int r = drawHeight/2;
	      int ringCenterR = (r*11/12);
	      
	      //create ball size
	      
	      int ballWidth = r/14;
	      int ballHeight = r/14;
	      
	      //BallCentering Mathematics
	      
	      int centerBallPosX = (widthPos + drawWidth/2) - ballWidth/2;
	      int centerBallPosY = (heightPos + drawHeight/2) - ballHeight/2;    
	               
	      //TRIG, GIVING THE X AND Y ACCORDING TO THE RINGCENTERRADIU
	      
	      int slotPosition = callback.getCurrentSlotPosition();
			
	      double positionAngle = ((slotPosition - 8)*360/38);
	      
	      //ANGLES
	      
	      //this 5.45 magic number is the angle of half a slot, it fixes it to put it in the center
	      double translatedY = (Math.sin(Math.toRadians(positionAngle - 5.45))) * ringCenterR;
	      double translatedX = (Math.cos(Math.toRadians(positionAngle - 5.45))) * ringCenterR;
	      
	      // APPLY THESE VALUES TO CENTER POSITION
	      
	      double ringCenterPosY = centerBallPosY + translatedY;
	      double ringCenterPosX = centerBallPosX + translatedX;
	           
	      // this draws the image according to the specifications set above
	      d.drawImage(img,widthPos,heightPos,drawWidth,drawHeight,this);	      
	      
	      d.setColor(Color.YELLOW);
	      d.fillOval((int)ringCenterPosX, (int)ringCenterPosY, ballWidth, ballHeight); 
	     
	   }
}
