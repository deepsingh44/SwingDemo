package com.deepsingh44.util;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.deepsingh44.ui.LoginFile;

public class Utility {
	public static final String [] CATEGORY= {"Category", "Food", "Policy/Bill", "Shopping", "Others"};
	
public static ImageIcon resize(ImageIcon icon,int w,int h) {
	BufferedImage bi=new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	Graphics2D gd=(Graphics2D)bi.createGraphics();
	gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	gd.drawImage(icon.getImage(), 0,0,w,h,null);
	gd.dispose();
	return new ImageIcon(bi);
}

private static String emailPattern="^[a-zA-Z0-9]{1,20}@[a-zA-Z]{1,10}.[a-zA-Z]{2,3}$";
//how to use regex and what is the benifit
public static boolean emailValidation(String email) {
	return Pattern.compile(emailPattern).matcher(email).matches();	
}
private static String passwordPattern="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!?&()@$%#]).{6,15})";
public static boolean passwordValidation(String pass) {
	return Pattern.compile(passwordPattern).matcher(pass).matches();
}

public static void warningMessage(Component cmp,String msg) {
	JOptionPane.showMessageDialog(cmp, msg,"Warning-Message",JOptionPane.WARNING_MESSAGE);
}

}
