import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.util.Scanner;

public class outline {

	public static void main(String [] args) throws Exception{
		
		//Input image, has to be in ARGB format
		File file = new File("test.png");
		BufferedImage image =  ImageIO.read(file);
		
		//Check if file exists
		if( !file.exists() ) {
			System.exit(0);
		}	
		
		//Takes user input, inputs an INT
		Scanner user_input = new Scanner( System.in );
		System.out.print("Please enter Alpha value (0-255): ");
		int a = user_input.nextInt();
		
		System.out.print("Please enter Red value (0-255)  : ");
		int r = user_input.nextInt();
		
		System.out.print("Please enter Green value (0-255): ");
		int g = user_input.nextInt();
		
		System.out.print("Please enter Blue value (0-255) : ");
		int b = user_input.nextInt();

		//Sets the border color
		Color border = new Color(r,g,b,a);
	
		//Height and Width of the Image
		int w = image.getWidth();
		int h = image.getHeight();
	
		//loops through all the pixels
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				
				if(i == 0) {
					if(image.getRGB(j,i) != -1) {
						//sets the border pixels to desired color
						image.setRGB(j,i,border.getRGB());
					}
				}
				
				if(i == h-1) {
					if(image.getRGB(j,i) != -1) {
						//sets the border pixels to desired color
						image.setRGB(j,i,border.getRGB());
					}
				}
				
				if(j == 0) {
					if(image.getRGB(j,i) != -1) {
						//sets the border pixels to desired color
						image.setRGB(j,i,border.getRGB());
					}
				}
				
				if(j == w-1) {
					if(image.getRGB(j,i) != -1) {
						//sets the border pixels to desired color
						image.setRGB(j,i,border.getRGB());
					}
				}

				else if(i > 0 && i < h-1 && j > 0 && j < w-1){
					int before = image.getRGB(j-1,i);
					int after = image.getRGB(j+1,i);
					int above = image.getRGB(j,i+1);
					int under = image.getRGB(j,i-1);
					
					if(before == -1 || after == -1 || above == -1 || under == -1) {
						
						if(image.getRGB(j,i) != -1) {
						//sets the border pixels to desired color
						image.setRGB(j,i,border.getRGB());
						}
					}
				}
				
				/*
				finds the border pixels
				if(i == 0 || i == h-1 || j == 0 || j == w-1)
				{
					//sets the border pixels to desired color
					//image.setRGB(j,i,border.getRGB());
				}*/
			}
		}
		
		File output = new File("output.png");
		ImageIO.write(image, "png", output);	
	}
}


