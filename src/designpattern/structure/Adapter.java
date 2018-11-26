package designpattern.structure;

import java.io.File;

public class Adapter {

	public static void main(String[] args) {
		File file=new File("Test.txt");
	    FileCommiter fileCommiter=new FileCommiter("C:\\");
	    fileCommiter.saveFile(file);//This will save the file on the disk location C: drive
	    //Now we want to email with the same Target class FileCommiter
	    fileCommiter=new FileEmailerAdapter(new FileEmailerAdaptee("abcd@javabrahman.com"));
	    fileCommiter.saveFile(file);//This will email the file to abcd@javabrahman.com

	}
}

	class FileCommiter {
		String diskLocation;

		public FileCommiter() {
			// default constructor
		}

		public FileCommiter(String diskLocation) {
			this.diskLocation = diskLocation;
		}

		public void saveFile(File file) {
			System.out.println("");
		}
	}
	
	interface MailAdaptee{
		void sendFile(File file);
	}
	
	class FileEmailerAdaptee implements MailAdaptee{
		public String emailAddress;

		public FileEmailerAdaptee(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public void sendFile(File file) {
			System.out.println("File has been mail to mentioned email id..."+emailAddress);
		}
	}
	
	class FileFTPAdaptee implements MailAdaptee{
		public String emailAddress;

		public FileFTPAdaptee(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public void sendFile(File file) {
			System.out.println("File has been uploaded to mentioned FTP location...");
		}
	}
	
	
	class FileEmailerAdapter extends FileCommiter {
		public MailAdaptee fileEmailer;

		public FileEmailerAdapter(MailAdaptee fileEmailer) {
			this.fileEmailer = fileEmailer;
		}

		public void saveFile(File file) {
			this.fileEmailer.sendFile(file);
		}
	}

