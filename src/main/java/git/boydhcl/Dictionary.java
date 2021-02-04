package git.boydhcl;
import java.util.*;


public class Dictionary {
	private ArrayList<String> words;
	
	public void addWord(String word) {
		words.add(word);
	}
	
	public boolean checkWord(String word) {
		for(Iterator<String> it = words.iterator(); it.hasNext() ; it.next()) {
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
