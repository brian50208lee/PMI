package nltk.metrics.association;

import java.util.ArrayList;

public class NgramAssocMeasures {
	int _n=0;
	int NGRAM = 0;
	int TOTAL = -1;
	int UNIGRRAMS = -2;
    public double pmi(int[] marginals){
    	int maxIdx = marginals.length ;
    	
    	ArrayList<Integer> subMargine = new ArrayList<>();
    	for (int i = maxIdx + UNIGRRAMS; i >0 ; i--) subMargine.add(marginals[i]);
    	
    	
    	
        return _log2(marginals[NGRAM] * Math.pow( marginals[maxIdx+TOTAL], _n - 1) ) -
        		_log2(_product(subMargine));
    }
    private double _log2(double value){
    	return Math.log(value)/Math.log(2);
    }
    private int _product(ArrayList<Integer> value){
    	int prod = 1;
    	for (int i :value) prod*=i;
    	return prod;
    	
    }
}
