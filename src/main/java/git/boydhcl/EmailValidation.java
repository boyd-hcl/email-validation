package git.boydhcl;
import java.io.*;

public class EmailValidation {
	public static void main(String[] args) {
		
		//Declare object for validating format
		String emailRegex = "^[\\.\\w]+@[\\w]+(\\.[\\w]+)+$";
		FormatChecker formatChecker = new FormatChecker(emailRegex);
		
		//Declare dictionary to collect e-mails to check against
		Dictionary dictionary = new Dictionary();
		
		System.out.println("Welcome to the email validation app!\n"
				+ "Please input an email address to check that it has the proper format\n"
				+ "and to verify that it does not match any of a set of existing email addresses."
				+ "\n"
				+ "To begin, please input the name of a file containing email addresses, each on a separate line.");
		boolean successful = false;
		while(!successful) {
			try {
				File emailFile = new File(System.console().readLine());
				BufferedReader emailReader = new BufferedReader(new FileReader(emailFile));
				successful = true;
				String s = emailReader.readLine();
				while(s!=null) {
					dictionary.addWord(s);
					s = emailReader.readLine();
				}
			}
			catch(Exception e) {
				System.out.println("\n\n"
						+ "File not found. Please input the filename again, checking closely for errors.");
			}
		}
		
		
		String input = "";
		while(input != "k") {
		
		}

		
	}
}
