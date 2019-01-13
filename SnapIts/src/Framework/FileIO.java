package Framework;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import GUI.GUI;
import Main.Main;

public class FileIO {
	private static JFileChooser fileChooser;
	private static File file = null;

	public FileIO() {
		fileChooser = new JFileChooser();
	}

	public BufferedImage getImage(String path) {
		BufferedImage s;
		try {
			s = ImageIO.read(new File(path));
		} catch (IOException e) {
			return null;
		}
		return s;
	}

	public String fileIOString() {
		String string = "";
		string += "!#FILEIO#!\n";

		string += "file:" + getFile() + "\n";

		string += "!#END_FILEIO#!\n";
		return string;
	}

	public void openFile() {
		fileChooser = new JFileChooser();
		String[] extensionFilters = { "snaps" };
		FileNameExtensionFilter restrict = new FileNameExtensionFilter(getExtensionString(extensionFilters),
				extensionFilters);
		fileChooser.addChoosableFileFilter(restrict);
		fileChooser.setFileFilter(restrict);
		fileChooser.setSelectedFile(file);
		fileChooser.showOpenDialog(null);
		file = fileChooser.getSelectedFile();

		String fileString = readFile();
		String fileIOString = fileString.substring(fileString.indexOf("!#FILEIO#!") + 11, fileString.indexOf("!#END_FILEIO#!"));
		
		ArrayList<String> fileIOStringList = lineParser(fileIOString);
		for (int i = 0; i < fileIOStringList.size(); i++) {
			if (fileIOStringList.get(i).startsWith("file:")) {
				file = new File(fileIOStringList.get(i).substring(5, fileIOStringList.get(i).length()));
			}
		}
		
		String projcetString = fileString.substring(fileString.indexOf("!#PROJECT#!") + 12, fileString.indexOf("!#END_PROJECT#!"));
		GUI.panelProject.load(projcetString);
		Main.gui.changePanel(GUI.panelProject);
	}

	public void saveFile() {
		if (file != null) {
			write2File(fileIOString() + GUI.panelProject.save());
		} else {
			saveAsFile();
		}
	}

	public void saveAsFile() {
		fileChooser = new JFileChooser();
		String[] extensionFilters = { "snaps" };
		FileNameExtensionFilter restrict = new FileNameExtensionFilter(getExtensionString(extensionFilters),
				extensionFilters);
		fileChooser.addChoosableFileFilter(restrict);
		fileChooser.setFileFilter(restrict);
		if (file == null) {
			fileChooser.setSelectedFile(new File("project.snaps"));
		} else {
			fileChooser.setSelectedFile(file);
		}
		fileChooser.showSaveDialog(null);
		file = fileChooser.getSelectedFile();
		saveFile();
	}

	public static void write2File(String text) {
		try {
			PrintWriter writer = new PrintWriter(Main.framework.fileIO.getFilePath(), "UTF-8");
			writer.print(text);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static String readFile() {
		String text = null;

		String st;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
				text += st + "\n";
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		text = text.replaceFirst("null", "");
		return text;
	}

	public void clearFile() {
		fileChooser = new JFileChooser();
		file = null;
	}

	public String getFilePath() {
		return file.getPath();
	}

	public String getFileName() {
		return file.getName();
	}

	public File getFile() {
		return file;
	}
	
	public ArrayList<String> lineParser(String string) {
		ArrayList<String> list = new ArrayList<String>();
		int start = 0;
		for (int i = 0; i < string.length(); i++) {
			if (Character.toString(string.charAt(i)).equals("\n")) {
				list.add(string.substring(start, i));
				start = i + 1;
			}
		}
		return list;
	}

	public String getExtensionString(String[] list) {
		String s = "Only ";
		for (int i = 0; i < list.length; i++) {
			s += ".";
			s += list[i];
			if (list.length > 1) {
				if (i < list.length - 1) {
					s += ", ";
				}
			}
		}
		s += " files";
		return s;
	}

}