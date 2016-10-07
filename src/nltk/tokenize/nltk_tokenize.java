package nltk.tokenize;

public class nltk_tokenize {
	public static String[] word_tokenize(String str){
		/* 
		 * not implement by original nltk design
		 * 
		 * just slit String to Array by "space"
		 */
		return str.split(" |\n");
	}
}
