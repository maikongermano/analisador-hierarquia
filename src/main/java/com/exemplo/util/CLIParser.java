package com.exemplo.util;

import com.exemplo.model.WordNode;

public class CLIParser {
	private int depth = 1;
	private boolean verbose = false;
	private String phrase;

	public CLIParser(String[] args) {
		parseArgs(args);
	}

	private void parseArgs(String[] args) {
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
			case "--depth":
				if (i + 1 < args.length) {
					depth = Integer.parseInt(args[++i]);
				} else {
					throw new IllegalArgumentException("Valor para --depth não especificado.");
				}
				break;
			case "--verbose":
				verbose = true;
				break;
			default:
				if (phrase == null) {
					phrase = args[i].replace("\"", "");
				} else {
					phrase += " " + args[i].replace("\"", "");
				}
				break;
			}
		}

		if (phrase == null) {
			throw new IllegalArgumentException("Nenhuma frase foi fornecida para análise.");
		}
	}

	public int getDepth() {
		return depth;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public String getPhrase() {
		return phrase;
	}

	public void executeAnalysis(WordNode root) {
		if (root == null) {
			throw new IllegalArgumentException("Raiz da hierarquia não pode ser nula.");
		}

		PhraseAnalyzer analyzer = new PhraseAnalyzer(root);

		long startTime = System.currentTimeMillis();
		analyzer.analyze(phrase, depth);
		long analysisTime = System.currentTimeMillis() - startTime;

		if (verbose) {
			System.out.println("Tempo de verificação da frase: " + analysisTime + "ms");
		}
	}
}
