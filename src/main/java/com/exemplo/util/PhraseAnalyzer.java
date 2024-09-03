package com.exemplo.util;

import java.util.HashMap;
import java.util.Map;

import com.exemplo.model.WordNode;

public class PhraseAnalyzer {
	private WordNode root;

	public PhraseAnalyzer(WordNode root) {
		this.root = root;
	}

	public Map<String, Integer> analyze(String phrase, int depth) {
		Map<String, Integer> wordCount = new HashMap<>();
		String[] words = phrase.toLowerCase().split("\\s+");

		for (String word : words) {
			countWordsAtDepth(root, word, depth, wordCount);
		}

		return wordCount;
	}

	private void countWordsAtDepth(WordNode node, String word, int depth, Map<String, Integer> wordCount) {
		System.out.println("Verificando: " + node.getWord() + " na profundidade " + node.getDepth());

	    if (node.getDepth() == depth && node.getWord().equalsIgnoreCase(word)) {
	        wordCount.put(node.getWord(), wordCount.getOrDefault(node.getWord(), 0) + 1);
	        System.out.println("Correspondência encontrada: " + node.getWord());
	    }

	    for (WordNode subNode : node.getSubcategories()) {
	        countWordsAtDepth(subNode, word, depth, wordCount);
	    }
	}
}
