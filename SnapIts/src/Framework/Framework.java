package Framework;

public class Framework {

	public FileIO fileIO;
	
	public Framework() {
		init();
    }

	public void init() {
		fileIO = new FileIO();
	}
	
	public void close() {
		
	}

	public void reset() {
		fileIO.clearFile();
	}
	
}