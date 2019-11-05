package task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Execute {

	public static void main(String[] args) {

		WordPair wordPair = new WordPair();
		String fileName = "C:/Users/arvin/OneDrive/Documents/loshiga/input_s3.txt";
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

				for (int i = 1; i < titleSplitter.length; i++) {
					wordPair.addPair(titleSplitter[0], titleSplitter[i]);
				}

			}
			wordPair.printIfIdf(args[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
