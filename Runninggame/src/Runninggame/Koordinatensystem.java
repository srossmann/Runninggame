/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runninggame;

import java.awt.image.BufferedImage;

/**
 *
 * @author rossmann
 */
public class Koordinatensystem {

	public int FormHeight = 0;
	public int FormWidth = 0;
	public int xFactor = 0;
	public int yFactor = 0;
	public int xRaster = 0;
	public int yRaster = 0;

	public Koordinatensystem(int xRaster, int yRaster) {
		this.xRaster = xRaster;
		this.yRaster = yRaster;
	}

	public void setGroesse(int FormHeight, int FormWidth) {
		this.FormHeight = FormHeight;
		this.FormWidth = FormWidth;
	}

	public Size getGlobalFormPos(int x, int y) {
		Size GlSize = new Size();
		GlSize.GFXPos = x;
		GlSize.GFYPos = FormHeight - y;
		return GlSize;
	}

	public Size getGlobalImagePos(BufferedImage ImageObjeckt, int x, int y) {
		Size GlSize = new Size();
		GlSize.GFXPos = getGlobalFormPos(x, y).GFXPos;
		GlSize.GFYPos = getGlobalFormPos(x, y).GFYPos - ImageObjeckt.getHeight();
		return GlSize;
	}

	public class Size {

		public int GFXPos;
		public int GFYPos;
	}

}
