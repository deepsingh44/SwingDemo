package com.deepsingh44.util;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Utility {
public static ImageIcon resize(ImageIcon icon,int w,int h) {
	BufferedImage bi=new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	Graphics2D gd=(Graphics2D)bi.createGraphics();
	gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	gd.drawImage(icon.getImage(), 0,0,w,h,null);
	gd.dispose();
	return new ImageIcon(bi);
}
}
