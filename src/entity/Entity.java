package entity;

import java.awt.image.BufferedImage;

public class Entity {

	public int x, y;
	public int speed;

	public BufferedImage up1, up2, upStill, down1, down2, downStill, left1, left2, leftStill, right1, right2, rightStill;
	public String direction;

	public int spriteCounter = 0;
	public int spriteNum = 1;
	boolean moving = false;
}
