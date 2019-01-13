package GUI;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class FontImporter {

	public FontImporter() {
		importFont("Roboto-Black");
	}
	
	public void importFont(String name) {
		String s = File.separator;
		try {
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts" + s + name + ".ttf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
			System.out.println("Font " + name + " didn't load");
		}
	}
	
}
