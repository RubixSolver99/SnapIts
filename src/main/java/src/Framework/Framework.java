package src.Framework;

public class Framework {

	public FileIO fileIO;

	public Framework() {
		init();
    }

	public void init() {
		fileIO = new FileIO();

		//test run
		System.out.println(PythonIO.runPython());
	}
}