package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
		
	}
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}

	public void getPlayerImage() {
		try {

			up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/up2.png"));
			upStill = ImageIO.read(getClass().getResourceAsStream("/res/player/upStill.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/down2.png"));
			downStill = ImageIO.read(getClass().getResourceAsStream("/res/player/downStill.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/right2.png"));
			rightStill = ImageIO.read(getClass().getResourceAsStream("/res/player/rightStill.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/left2.png"));
			leftStill = ImageIO.read(getClass().getResourceAsStream("/res/player/leftStill.png"));

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		moving = false;
		if (keyH.upPressed == true) {
			direction = "up";
			y -= speed;
			moving = true;
		}
		else if (keyH.downPressed == true) {
			direction = "down";
			y += speed;
			moving = true;
		}
		else if (keyH.leftPressed == true) {
			direction = "left";
			x -= speed;
			moving = true;
		}
		else if (keyH.rightPressed == true){
			direction = "right";
			x += speed;
			moving = true;
		}

		if (moving) {
		spriteCounter++;
		if (spriteCounter > 10) {
			spriteNum = (spriteNum == 1) ? 2 : 1;
			spriteCounter = 0;
		}
		} else {
			spriteNum = 0; // standing still
		}
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
			case "up":
				if (spriteNum == 0) image = upStill;
				else if (spriteNum == 1) image = up1;
				else if (spriteNum == 2) image = up2;
				break;
			case "down":
				if (spriteNum == 0) image = downStill;
				else if (spriteNum == 1) image = down1;
				else if (spriteNum == 2) image = down2;
				break;
			case "left":
				if (spriteNum == 0) image = leftStill;
				else if (spriteNum == 1) image = left1;
				else if (spriteNum == 2) image = left2;
				break;
			case "right":
				if (spriteNum == 0) image = rightStill;
				else if (spriteNum == 1) image = right1;
				else if (spriteNum == 2) image = right2;
				break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
}

