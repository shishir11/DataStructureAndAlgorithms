package designpattern.structure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

 abstract class TextFile {
	public abstract String getNameWithPath();

	public abstract FileInputStream getFileContents() throws java.io.FileNotFoundException;

	public static TextFile getTextFileInstance(String fileNameWithPath) {
		return new TextFileProxy(fileNameWithPath);
	}
}

 class RealTextFile extends TextFile {
	private String fileNameWithPath;

	public RealTextFile(String fileNameWithPath) {
		this.fileNameWithPath = fileNameWithPath;
	}

	public String getNameWithPath() {
		return this.fileNameWithPath;
	}

	public FileInputStream getFileContents() throws FileNotFoundException {
		File file = new File(this.fileNameWithPath);
		return new FileInputStream(file);
	}
}

 class TextFileProxy extends TextFile {
	private String fileNameWithPath;
	RealTextFile realTextFile = null;

	public TextFileProxy(String fileNameWithPath) {
		this.fileNameWithPath = fileNameWithPath;
	}

	public String getNameWithPath() {
		return this.fileNameWithPath;
	}

	public FileInputStream getFileContents() throws FileNotFoundException {
		this.realTextFile = new RealTextFile(this.fileNameWithPath);
		return realTextFile.getFileContents();
	}
}

public class Proxy {

	public static void main(String[] args) {
		TextFile textFile = TextFile.getTextFileInstance("/src/structure/Test.txt");
		System.out.println("TextFile's name with path is->" + textFile.getNameWithPath());
		// Till here TextFileProxy instance is created with the realTextFile instance in
		// it being null
		try {
			System.out.println("TextFile's content ->" + textFile.getFileContents());
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException exception thrown");
		}
	}

}
