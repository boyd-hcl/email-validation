package git.boydhcl;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FormatChecker {
	Pattern regex;
	
	public boolean checkFormat(String word) {
		Matcher match = regex.matcher(word);
		return match.find();
	}
	
	FormatChecker(String regex_in){
		regex = Pattern.compile(regex_in);
	}
}
