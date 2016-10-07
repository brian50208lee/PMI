package nltk.probability;

import java.util.HashMap;


import java.lang.Integer;;

public class FreqDist extends HashMap<String,Integer> {
	public void add(String word1 , int valueToAdd){
		int newValue = valueToAdd;
		if (get(word1) != null) {
			newValue = newValue + (int)get(word1);
		}
		put(word1, new Integer(newValue));
	}
	
	public void add(String word1,String word2 , int valueToAdd){
		String wordPair = word1+"," + word2 ; 
		add(wordPair, valueToAdd);
	}
	
	public Integer get(String word1,String word2){
		String wordPair =  word1+"," + word2 ; 
		return get(wordPair);
	}
	
	
	public int N(){
		int total=0;
		for (String key : keySet()) {
			//System.out.printf("%-20s%d\n",key , get(key));
			total += get(key);
		}
		return total;
	}
}
