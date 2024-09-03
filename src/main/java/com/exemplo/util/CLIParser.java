package com.exemplo.util;

import java.util.Map;

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

	public Map<String, Integer> executeAnalysis(PhraseAnalyzer analyzer) {
		return analyzer.analyze(phrase, depth);
	}
}
