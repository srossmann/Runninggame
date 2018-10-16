/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runninggame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author rossmann
 */
public class Figur {

	private BufferedImage[] BildfolgeLinks = null;
	private BufferedImage[] BildfolgeRechts = null;
	private ImageObserver myImageObserver = null;
	private Koordinatensystem myKoordinatensystem = null;
	private int myBildNr = 0;
	private int Verzoegerung = 0;
	private int mySpeed = 10;
	private boolean myAnimiStart = false;
	private static final String ImagePathLinks = "Ressourcen/Figur1/LaufenLinks/Bild";
	private static final String ImagePathRechts = "Ressourcen/Figur1/LaufenRechts/Bild";
	private int XPos = 0;
	private int YPos = 0;
	private boolean visible = false;
	private boolean richtung = false;

	public Figur(ImageObserver io, Koordinatensystem Ks) {
		myKoordinatensystem = Ks;
		try {
			this.myImageObserver = io;
			BildfolgeLinks = new BufferedImage[12];
			BildfolgeRechts = new BufferedImage[12];
			LadeImage();
		} catch (IOException ex) {
			Logger.getLogger(Figur.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public int Animi(Graphics myGraphic) {
		if (visible) {
			Verzoegerung++;
			if (Verzoegerung == mySpeed) {
				Verzoegerung = 0;
				if (myAnimiStart) {
					myBildNr++;
					if (myBildNr == 12) {
						myBildNr = 1;
						myAnimiStart = false;
					}
				}
			}
			if (richtung) {
				paintRechts(myGraphic, myBildNr, XPos, YPos);
			} else {
				paintLinks(myGraphic, myBildNr, XPos, YPos);
			}
		}
		return myBildNr;
	}

	public void setSpeed(int Speed) {
		mySpeed = Speed;
		Verzoegerung = 0;
	}

	public void setPosition(boolean visible, int XPos, int YPos) {

		this.XPos = XPos;
		int h = BildfolgeLinks[0].getHeight();
		this.YPos = YPos - h;
		// this.XPos = myKoordinatensystem.getGlobalImagePos(BildfolgeLinks[0], XPos,
		// YPos).GFXPos;
		// this.YPos = myKoordinatensystem.getGlobalImagePos(BildfolgeLinks[0], XPos,
		// YPos).GFYPos;
		this.visible = visible;
	}

	public void StartAnimi(String Richtung) {
		if (Richtung == "L") {
			richtung = false;
		}
		if (Richtung == "R") {
			richtung = true;
		}
		myAnimiStart = true;
	}

	private void LadeImage() throws IOException {
		int i1 = 0;
		for (int i = 0; i < 12; i++) {
			i1++;
			BildfolgeLinks[i] = ImageIO.read(getClass().getClassLoader().getResource(ImagePathLinks + i1 + ".png"));
			BildfolgeRechts[i] = ImageIO.read(getClass().getClassLoader().getResource(ImagePathRechts + i1 + ".png"));
			// Bildfolge[i] =
			// Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource(ImagePath
			// + i1 + ".png"));
		}
	}

	private void paintRechts(Graphics myGraphic, int BildNr, int XPos, int YPos) {
		myGraphic.drawImage(BildfolgeRechts[BildNr], XPos, YPos, myImageObserver);
	}

	private void paintLinks(Graphics myGraphic, int BildNr, int XPos, int YPos) {
		myGraphic.drawImage(BildfolgeLinks[BildNr], XPos, YPos, myImageObserver);
	}

}
