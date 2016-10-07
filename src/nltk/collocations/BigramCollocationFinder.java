package nltk.collocations;

import nltk.metrics.association.NgramAssocMeasures;
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
        for (String[] window:nltk_util.ngrams(words, window_size,false,true,null,null)) {
        	
			String w1 = window[0];
			if (w1 == null) {
				continue;
			}
			wfd.add(w1, 1);
			for (int i = 1  ; i < window.length; i++) {
				String w2=window[i];
				if (w2 != null) {
					bfd.add(w1, w2, 1);
				}
			}
		}
        return new BigramCollocationFinder(wfd, bfd);
	}



	@Override
	public Double score_ngram(NgramAssocMeasures score_fn, String w[]) {
        int n_all = N;
        int n_ii = (int) (ngram_fd.get(w[0], w[1]) / (window_size - 1.0)) ;
        if ( n_ii ==0)return null;
        int n_ix = word_fd.get(w[0]);
        int n_xi = word_fd.get(w[1]);
        
        int marginals[]=new int[4];
        marginals[0]=n_ii;
        marginals[1]=n_ix;
        marginals[2]=n_xi;
        marginals[3]=n_all;
        
		return new Double(score_fn.pmi(marginals));
	}

}
