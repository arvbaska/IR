package task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

public class WordPair {
	ArrayList<String> words;
	ArrayList<String> documents;

	public WordPair() {
		words = new ArrayList<String>();
		documents = new ArrayList<String>();
	}

	public void addPair(String word, String document) {
		words.add(word);
		documents.add(document);
	}

	public void printIfIdf(String fileName) {
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write("\t");
			for (String doc : new HashSet<>(documents)) {
				writer.write(doc + "\t");
			}
			writer.write("\n");
			for (String word : new HashSet<>(words)) {
				writer.write(word + "\t");
				for (String doc : new HashSet<>(documents)) {
					writer.write(getWeightMatrix(word, doc) + "\t");
				}
				writer.write("\n");
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	public double getWeightMatrix(String word, String document) {
		// getting index of the word
		double tf = totalOccurenceInDocument(word, document) / totalNumTermDocument(document);
		double idf = Math.log(totalDocuments() / totalTermsInDocument(word));

		return tf * idf;
	}

	public boolean isPair(String word, String document) {
		for (String eachWord : words) {
			for (String eachDocument : documents) {
				if (eachWord.equals(word) && eachDocument.equals(document)) {
					return true;
				}
			}

		}
		return false;
	}

	public double totalOccurenceInDocument(String word, String document) {
		int count = 0;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals(word) && documents.get(i).equals(document)) {
				count++;
			}

		}
		return count;
	}

	public int totalNumTermDocument(String document) {
		int count = 0;
		for (String eachDocument : documents) {
			if (eachDocument.equals(document)) {
				count++;
			}
		}

		return count;
	}

	public int totalDocuments() {
		Set<String> set = new HashSet<>(documents);
		return set.size();
	}

	public int totalTermsInDocument(String word) {
		int count = 0;
		for (String eachDocument : words) {
			if (eachDocument.equals(word)) {
				count++;
			}
		}

		return count;
	}
	
	private void writeFile(HashMap<String, ArrayList<String>> map) {
		String fileName = "C:/Users/arvin/OneDrive/Documents/loshiga/output.txt";
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
