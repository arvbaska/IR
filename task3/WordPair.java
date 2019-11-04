package task3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

	public void printIfIdf() {
		System.out.print("\t");
		for (String doc : new HashSet<>(documents)) {
			System.out.print(doc + "\t");
		}
		System.out.println();
		for (String word : new HashSet<>(words)) {
			System.out.print(word + "\t");
			for (String doc : new HashSet<>(documents)) {
				System.out.print(getWeightMatrix(word, doc) + "\t");
			}
			System.out.println();
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

}
