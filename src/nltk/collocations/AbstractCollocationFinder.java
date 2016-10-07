package nltk.collocations;

import java.util.ArrayList;
import java.util.Comparator;

import nltk.metrics.association.NgramAssocMeasures;
import nltk.probability.FreqDist;

public abstract class AbstractCollocationFinder {
	public FreqDist word_fd;
	public FreqDist ngram_fd;
	public int N;
	public AbstractCollocationFinder(FreqDist word_fd,FreqDist ngram_fd){
		this.word_fd=word_fd;
		this.ngram_fd=ngram_fd;
		this.N=word_fd.N();
	}
	private ArrayList<Object[]> _score_ngrams(NgramAssocMeasures score_fn){
		
		ArrayList<Object[]> result =new ArrayList<Object[]>();
		for( String tup :ngram_fd.keySet()){
			String tupArr[] = tup.split(",");
			Double score = score_ngram(score_fn, tupArr);
			if (score != null) {
				Object obj[] = new Object[2];
				obj[0]=tupArr;
				obj[1]=score;
				result.add(obj);
			}
		}
		return result;
	}
    public ArrayList<Object[]> score_ngrams( NgramAssocMeasures score_fn){
    	ArrayList<Object[]> score_result = _score_ngrams(score_fn);
    	//sort
    	score_result.sort(new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				
				return -((Double)(o1[1])).compareTo(((Double)(o2[1])));
			}
		});
    	return score_result;
    }
    
    public abstract Double score_ngram(NgramAssocMeasures score_fn,String w[]);

}
