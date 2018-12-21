package src.Framework;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileIO {
	private static JFileChooser fileChooser;
	private static File file;

	public FileIO() {
		fileChooser = new JFileChooser();
	}

	public void openFile() {
		fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		file = fileChooser.getCurrentDirectory();
	}

	public void openFile(String... extensionFilters) {
		fileChooser = new JFileChooser();
		FileNameExtensionFilter restrict = new FileNameExtensionFilter(getExtensionString(extensionFilters), extensionFilters);
		fileChooser.addChoosableFileFilter(restrict);
		fileChooser.setFileFilter(restrict);
		fileChooser.showOpenDialog(null);
		file = fileChooser.getCurrentDirectory();
	}

	public void saveFile() {
		fileChooser = new JFileChooser();
		fileChooser.showSaveDialog(null);
		file = fileChooser.getCurrentDirectory();
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

	public String getExtensionString(String[] list) {
		String s = "Only ";
		for (int i = 0; i < list.length; i++) {
			s += ".";
			s += list[i];
			if (list.length > 1) {
				if (i < list.length - 1) {
					s+= ", ";
				}
			}
		}
		s += " files";
		return s;
	}

}