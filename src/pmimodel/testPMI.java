package pmimodel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.IntFunction;

import nltk.collocations.BigramCollocationFinder;
import nltk.metrics.association.BigramAssocMeasures;
import nltk.tokenize.nltk_tokenize;

public class testPMI {

	public static void main(String[] args) throws IOException {
		String path = "allKeywords(remove duplicated)";
		BufferedWriter output = new BufferedWriter(new FileWriter(new File("pmi_value")));
		BigramAssocMeasures bigram_measures;
		StringBuilder alltxt=new StringBuilder("");
		
		for(String f : new File(path).list()){
			BufferedReader file = new BufferedReader(new FileReader(new File(path+"/"+f)));
			String lines[] =file.lines().toArray(String[]::new);
			
			for (int i=0 ; i<lines.length;i++) {
				String txt=lines[i].replace("\n","");
				for( int j=i+1; j<lines.length;j++){
					if( txt.equals(lines[j].replace("\n","")) );
						alltxt.append(txt+" "+ lines[j].replace("\n","")+"\n");
				}
			}
		}
		//System.out.println(alltxt.toString());

		
		 bigram_measures= new BigramAssocMeasures();
		 
		 //System.out.println(nltk_tokenize.word_tokenize(alltxt.toString())[10]);
		 
		 BigramCollocationFinder finder=null;
		 try {
			finder = BigramCollocationFinder.from_words(nltk_tokenize.word_tokenize(alltxt.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		 System.out.println("output ...");
		 for(Object i[] :finder.score_ngrams(new BigramAssocMeasures())){
			 	String s1= String.format("%-20s",((String[])(i[0]))[0] ); 
			 	String s2= String.format("%-20s",((String[])(i[0]))[1] );
			 	String s3= String.format("%-20f\n",(double)(i[1])  ); 
			    output.write(s1+s2+s3);
			    //output.write(i[0][0]+" "+i[0][1]+" "+str(i[1])+'\n')
		 }
		 System.out.println("done");
		 
		 
	}

}
