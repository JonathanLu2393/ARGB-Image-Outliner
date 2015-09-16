import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;

public class outline {

	public static void main(String [] args) throws Exception{
		
		//Input image, has to be in ARGB format
		File file = new File("input_image.png");
		BufferedImage image =  ImageIO.read(file);
		
		//Check if file exists
		if( !file.exists() ) {
			System.exit(0);
		}	
	
		//Creating the border color
		int a = 0;
		int r = 0;
		int g = 0;
		int b = 0;
		Color border = new Color(r,g,b,a);
	
		//Height and Width of the Image
		int w = image.getWidth();
		int h = image.getHeight();
		System.out.println("width, height: " + w + ", " + h);
	
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int pixel = image.getRGB(j, i);
				int alpha = (pixel >> 24) & 0xff;
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				if(i == 0 || i == h-1 || j == 0 || j == w-1)
				{
					//System.out.println("x,y: " + j + ", " + i);
					//System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
					image.setRGB(j,i,border.getRGB());
				}
			}
		}
		
		File output = new File("output.png");
		ImageIO.write(image, "png", output);
		
	}
}


