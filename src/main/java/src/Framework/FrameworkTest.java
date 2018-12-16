package src.Framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrameworkTest {

	public static void main(String[] Args) throws IOException, InterruptedException {
		ProcessBuilder ps = new ProcessBuilder("python.exe", "ScriptTest.py");

		// From the DOC: Initially, this property is false, meaning that the
		// standard output and error output of a subprocess are sent to two
		// separate streams
		ps.redirectErrorStream(true);

		Process pr = ps.start();

		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		pr.waitFor();
		System.out.println("ok!");

		in.close();
		System.exit(0);
	}
}