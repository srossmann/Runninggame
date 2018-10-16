/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runninggame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author rossmann
 */
public class Wegplatte {
	private BufferedImage Wegobject = null;
	private Random zufallsgenerator = new Random();
	private static final String ImagePath = "Ressourcen/Weg.png";
	private ImageObserver myImageObserver = null;

	public Wegplatte(ImageObserver io) {
		myImageObserver = io;
		int zahl = zufallsgenerator.nextInt(4) + 1;
		try {
			Wegobject = ImageIO.read(getClass().getClassLoader().getResource(ImagePath));
		} catch (IOException ex) {
			Logger.getLogger(Baum.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void paint(Graphics myGraphic, int iXPos, int iYPos) {
		myGraphic.drawImage(Wegobject, iXPos, iYPos, 100, 50, myImageObserver);
	}
}
