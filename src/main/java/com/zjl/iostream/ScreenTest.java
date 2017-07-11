package com.zjl.iostream;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenTest {
	public static void main(String[] args) throws AWTException, IOException {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(dimension);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(rect);
		ImageIO.write(image, "png", new File("C:/Users/king-zheng/Desktop/out.png"));
	}
}
