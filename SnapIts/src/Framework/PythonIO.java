package Framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PythonIO {

	public static void write2Script(String text) {
		try {
			PrintWriter writer = new PrintWriter("src\\Framework\\Script.py", "UTF-8");
			writer.print(text);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void write2Script(String text, boolean isAdding) {
		if (isAdding) {
			try {
				String original = getScript();
				PrintWriter writer = new PrintWriter("src\\Framework\\Script.py", "UTF-8");
				writer.print(original + text);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			write2Script(text);
		}
	}

	public static String getScript() {
		String text = null;
		try {
			FileInputStream fis = new FileInputStream("src\\Framework\\Script.py");
			InputStreamReader in = new InputStreamReader(fis, "UTF-8");
			text = in.toString();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public static void runPython() {
		Runtime r = Runtime.getRuntime();
		
		try {
			r.exec("py C:\\Users\\Carson\\git\\SnapIts\\src\\Framework\\Script.py");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}