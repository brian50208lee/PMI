package nltk.util;

import javax.sound.midi.Sequence;

import nltk.probability.FreqDist;

public class nltk_util {
	public static String[][] ngrams(String sequence[],int window_size,
			boolean pad_left,boolean pad_right,
			String left_pad_symbol,String right_pad_symbol){

		
		//pad_sequence
		System.out.print(sequence.length +",");
		sequence = pad_sequence(sequence, window_size, pad_left, pad_right, left_pad_symbol, right_pad_symbol) ;
		System.out.println(sequence.length);
		String history[][] = new String[sequence.length + (pad_left?1:0) + (pad_right?1:0)][window_size];
		
		return new String[1][1];
	}
	
	public static String[] pad_sequence(String sequence[],int  n,
			boolean pad_left, 
			boolean pad_right,
			String left_pad_symbol,
			String right_pad_symbol){
		
		//calculate new length
		int pad_left_length=0;
		int pad_right_length=0;
		if (pad_left) pad_left_length += (n-1);
		if (pad_right) pad_right_length += (n-1);
		
		//new sequence
		int newSequenceLength=sequence.length + pad_left_length + pad_right_length;
		
		String newSequence[]=new String[newSequenceLength];
		int i,j,k;
		for (i = 0 ; i < pad_left_length; i++) newSequence[i]=left_pad_symbol;
		for (j = i ; j < i + sequence.length; j++)newSequence[j]=sequence[j-pad_left_length];
		for (k = j ; k < j+ pad_right_length; k++) newSequence[k]=left_pad_symbol;
		
		
		return newSequence;
	}
	
	
	private void pad_sequence(){
		
	}
}
