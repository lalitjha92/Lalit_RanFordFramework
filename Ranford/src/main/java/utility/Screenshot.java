package utility;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Screenshot {
	public static String CaptureScreenShot(String functionalityName)
	{
		try{
			Robot robotClassObject = new Robot();
			Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage tmp = robotClassObject.createScreenCapture(screenSize); 
            String path=System.getProperty("user.dir")+"/ScreenShots/"+functionalityName+System.currentTimeMillis()+".png";
            ImageIO.write(tmp, "png",new File(path)); 
            return path;
            
		}catch(Exception e)
		{
			System.out.println("Some exception occured." + e.getMessage());
			return "";
		}
	}
}

