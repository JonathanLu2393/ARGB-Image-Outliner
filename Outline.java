import javax.imageio.ImageIO
import java.awt.image.BufferedImage;
import java.io.IOException;

public class outline {

	public static void main(String [] args){
		
		//Input image, has to be in ARGB format
		File file = new File("input_image.png");
		BufferedImage image =  ImageIO.read(imageFile);
		
		//Check if file exists
		if( !file.exists() ) [
			System.exit(0);
		}	
	
	
	
	}
}


