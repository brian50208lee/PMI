package nltk.collocations;

import nltk.probability.FreqDist;
import nltk.util.nltk_util;

public class BigramCollocationFinder extends AbstractCollocationFinder{
	private int default_ws=2;
	private int window_size=2;
	public BigramCollocationFinder(FreqDist word_fd , FreqDist bigram_fd ){
		super(word_fd,bigram_fd);
	}
	public static BigramCollocationFinder from_words(String[] words  ) throws Exception{
		//default int window_size = 2
		return from_words(words, 2);
	} 
	
	
	public static BigramCollocationFinder from_words(String[] words , int window_size ) throws Exception{
        FreqDist wfd = new FreqDist();
        FreqDist bfd = new FreqDist();
		
		if (window_size < 2){
        	throw new Exception("Specify window_size at least 2");
        }
        for (String[] widow:nltk_util.ngrams(words, window_size,false,true,null,null)) {
			
		}
        
        
		return new BigramCollocationFinder(wfd, bfd);
	}

}
