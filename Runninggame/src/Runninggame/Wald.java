/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runninggame;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 *
 * @author rossmann
 */
public class Wald {

	private int BaumNummer = 0;
	private int GlobalePosition = 0;
	private Baum[] BaumLinie1 = null;
	private Baum[] BaumLinie2 = null;
	private ImageObserver myImageObserver = null;
	private int ImageBreite = 200;
	private int myAnzahlBaumObjekte = 500;
	private int myYPositon = 100;

	public Wald(ImageObserver io, int AnzahlBaumObjekte, int YPositon) {
		this.myAnzahlBaumObjekte = AnzahlBaumObjekte;
		this.myYPositon = YPositon;
		this.myImageObserver = io;
		BaumLinie1 = new Baum[myAnzahlBaumObjekte];
		BaumLinie2 = new Baum[myAnzahlBaumObjekte];
		for (int i = 0; i < myAnzahlBaumObjekte; i++) {
			BaumLinie1[i] = new Baum(myImageObserver);
			BaumLinie2[i] = new Baum(myImageObserver);
		}
	}

	public void Animi(Graphics myGraphic) {
		zeichneWald(myGraphic);
	}

	public void zeichneWald(Graphics myGraphic) {
		BaumNummer = GlobalePosition / ImageBreite;
		int iXPos = -ImageBreite + (-(GlobalePosition - (BaumNummer * ImageBreite)));
		for (int i = 0; i < 7; i++) {
			BaumLinie2[BaumNummer + i].paint(myGraphic, iXPos + 100, myYPositon - 50);
			iXPos = iXPos + ImageBreite;
		}
		iXPos = -ImageBreite + (-(GlobalePosition - (BaumNummer * ImageBreite)));
		for (int i = 0; i < 7; i++) {
			BaumLinie1[BaumNummer + i].paint(myGraphic, iXPos, myYPositon);
			iXPos = iXPos + ImageBreite;
		}

	}

	public void Step(int GlobalePosition) {
		this.GlobalePosition = GlobalePosition;
	}

}
