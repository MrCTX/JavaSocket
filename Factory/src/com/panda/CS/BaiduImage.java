package com.panda.CS;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

public class BaiduImage extends Applet{
	Button button;
	Image image;
	URL url;
	@Override
	public void init() {
		try {
			url = new URL("http://image.baidu.com/i?ct=503316480.jpg");
			image = getImage(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g){
		g.drawString("Image Address:", 0, 20);
		g.drawString(url.toExternalForm(), 0, 40);
		g.drawImage(image, 0, 50, this);
	}
	
}
