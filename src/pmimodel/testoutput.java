package pmimodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class testoutput {

	public static void main(String[] args) throws IOException {
		
		
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		BufferedReader file = new BufferedReader(new FileReader(new File("./pmi_value")));
		String line;
		while ((line=file.readLine()) != null) {
			String str = line.split(" ")[0] + "," +line.split(" ")[1];
			map.put(str, 0);
		}
		
		
		file = new BufferedReader(new FileReader(new File("./pmi_value2")));
		while ((line=file.readLine()) != null) {
			String str = line.split(" ")[0] + "," +line.split(" ")[1];
			if (map.get(str)==null)System.out.println(str+","+line.split(" ")[2]);
		}
		
		
		//

		
	}

}
