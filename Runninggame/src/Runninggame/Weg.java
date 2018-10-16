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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author rossmann
 */
public class Weg {
	private int WegNummer = 0;
	private int GlobalePosition = 0;
	private Wegplatte[] WegLinie = null;
	private ImageObserver myImageObserver = null;
	private int ImageBreite = 100;
	private int myAnzahlWgObjekte = 500;
	private int myYPositon = 300;

	public Weg(ImageObserver io, int AnzahlWegObjekte, int YPositon) {
		this.myAnzahlWgObjekte = AnzahlWegObjekte;
		this.myYPositon = YPositon;
		this.myImageObserver = io;
		WegLinie = new Wegplatte[myAnzahlWgObjekte];
		for (int i = 0; i < myAnzahlWgObjekte; i++) {
			WegLinie[i] = new Wegplatte(myImageObserver);
		}
	}

	public void Animi(Graphics myGraphic) {
		zeichneWeg(myGraphic);
	}

	public void zeichneWeg(Graphics myGraphic) {
		WegNummer = GlobalePosition / ImageBreite;
		int iXPos = -ImageBreite + (-(GlobalePosition - (WegNummer * ImageBreite)));
		for (int i = 0; i < 14; i++) {
			WegLinie[WegNummer + i].paint(myGraphic, iXPos, myYPositon);
			iXPos = iXPos + ImageBreite;
		}

	}

	public void Step(int GlobalePosition) {
		this.GlobalePosition = GlobalePosition;
	}
}
