package task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Execute {

	public static void main(String[] args) {

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		File file = new File(args[0]);
		FileReader fr = null;

		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String line;
		try {
			while ((line = br.readLine()) != null) {
				// process the line
				String[] titleSplitter = line.split("\t");

				for (String word : titleSplitter[1].split(" ")) {
					if (map.containsKey(word)) {
						map.get(word).add(titleSplitter[0]);
					} else {
						ArrayList<String> wordsArray = new ArrayList<String>();
						wordsArray.add(titleSplitter[0]);
						map.put(word, wordsArray);
					}

				}
			}

			System.out.println(map);
			writeFile(map, args[1]);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void writeFile(HashMap<String, ArrayList<String>> map, String fileName) {
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
				writer.write(entry.getKey() + "\t");
				for(String title : entry.getValue()) {
					writer.write(title + "\t");
				}
				writer.write("\n");
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
