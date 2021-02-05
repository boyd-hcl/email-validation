package git.boydhcl;
import java.util.*;
import git.boydhcl.*;


public class Dictionary {
	private ArrayList<String> words;
	
	public void addWord(String word) {
		words.add(word);
	}
	
	public boolean checkWordHasMatch(String word) {
		for(String it:words) {
			if(it.equals(word)) {
				return true;
			}
		}
		return false;
	}
	
	Dictionary(){
		words = new ArrayList<String>();
	}
}
