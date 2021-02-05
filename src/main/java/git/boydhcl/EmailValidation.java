package git.boydhcl;
import java.io.*;

public class EmailValidation {
	public static void main(String[] args) {
		
		//Declare object for validating format
		String emailRegex = "^[\\.\\w]+@\\w+(\\.[\\w]+)+$";
		FormatChecker formatChecker = new FormatChecker(emailRegex);
		
		//Declare dictionary to collect e-mails to check against
		Dictionary dictionary = new Dictionary();
		
		//intro message
		System.out.println("Welcome to the email validation app!\n"
				+ "Please input an email address to check that it has the proper format\n"
				+ "and to verify that it does not match any of a set of existing email addresses."
				+ "\n"
				+ "To begin, please input the name of a file containing a collection of email addresses, each on a separate line.");
		
		//Try to read emails from file until good filename is given by user
		boolean successful = false;
		while(!successful) {
			try {
				Console cnsl = System.console();
				File emailFile = new File(cnsl.readLine());
				BufferedReader emailReader = new BufferedReader(new FileReader(emailFile));
				successful = true;
				String s = emailReader.readLine();
				while(s!=null) {
					dictionary.addWord(s);
					s = emailReader.readLine();
				}
				emailReader.close();
				System.out.println("Email address list loaded");
			}
			catch(Exception e) {
				System.out.println("\n\n"
						+ "File not found. Please input the filename again, checking closely for errors.");
			}
		}
		
		//Read strings from the user, check that they have the proper format, 
		//and check against a set of strings in a file given by the user
		String input = "";
		while(input != "k") {
			System.out.println("\nPlease input a candidate email to check that it follows the format and that it matches an email in the list\n"
					+ "or enter k to exit.\n");
			input = System.console().readLine();
			if(input.equals("k")) {
				break;
			}
			if (formatChecker.checkFormat(input)) {
				System.out.println("This is a valid email. Checking if it matches an email on the list...");
				if (dictionary.checkWordHasMatch(input)) {
					System.out.println("This matches one of the email addresses in the list.");
				}
				else {
					System.out.println("This email does not match any email addresses in the list you provided.");
				}
			}
			else {
				System.out.println("This does not match the format of an email address");
			}
		}
		
	}
}
