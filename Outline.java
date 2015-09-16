import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Outline {

	public static void main(String [] args) throws Exception{
		
		//Input image, has to be in ARGB format
		File file = new File("input_image.png");
		BufferedImage image =  ImageIO.read(file);
		
		//Check if file exists
		if( !file.exists() ) {
			System.exit(0);
		}	
	
		//Height and Width of the Image
		int w = image.getWidth();
		int h = image.getHeight();
		System.out.println("width, height: " + w + ", " + h);
	
	}
	
	
	
	public void printPixelARGB(int pixel) {
		int alpha = (pixel >> 24) & 0xff;
		int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;
		System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
	}
	
	
}


