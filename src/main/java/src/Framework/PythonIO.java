package src.Framework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PythonIO {

	public static void write2Script(String text) {
		try {
			PrintWriter writer = new PrintWriter("src\\main\\java\\src\\Framework\\Script.py", "UTF-8");
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
				PrintWriter writer = new PrintWriter("src\\main\\java\\src\\Framework\\Script.py", "UTF-8");
				writer.print(original + text);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			write2Script(text);
		}
	}

	public static String getScript() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		String text = null;
		try {
			FileInputStream fis = new FileInputStream("src\\main\\java\\src\\Framework\\Script.py");
			InputStreamReader in = new InputStreamReader(fis, "UTF-8");
			text = in.toString();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public static String runPython() {
		Runtime r = Runtime.getRuntime();
		Process p = null;
		String s = null;
		String ss = "";

		try {
			p = r.exec("py C:\\Users\\Carson\\git\\SnapIts\\src\\main\\java\\src\\Framework\\Script.py");
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((s = stdInput.readLine()) != null) {
				ss += s;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ss;
	}
}