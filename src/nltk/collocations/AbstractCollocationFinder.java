package nltk.collocations;

import nltk.probability.FreqDist;

public abstract class AbstractCollocationFinder {
	FreqDist word_fd;
	FreqDist ngram_fd;
	int N;
	public AbstractCollocationFinder(FreqDist word_fd,FreqDist ngram_fd){
		this.word_fd=word_fd;
		this.ngram_fd=ngram_fd;
		this.N=word_fd.N();
	}
}
