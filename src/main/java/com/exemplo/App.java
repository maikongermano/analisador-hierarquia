package com.exemplo;

import com.exemplo.model.WordNode;
import com.exemplo.service.HierarchyLoader;
import com.exemplo.util.CLIParser;
import com.exemplo.util.PhraseAnalyzer;

import java.util.Map;

public class App {
	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();

			CLIParser cliParser = new CLIParser(args);

			String filePath = "dicts/hierarchy.json";
			HierarchyLoader loader = new HierarchyLoader();
			WordNode root = loader.loadHierarchy(filePath);

			long loadTime = System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			PhraseAnalyzer analyzer = new PhraseAnalyzer(root);
			Map<String, Integer> result = cliParser.executeAnalysis(analyzer);
			long analysisTime = System.currentTimeMillis() - startTime;

			if (result.isEmpty()) {
				System.out.println("0;");
			} else {
				result.forEach((key, value) -> System.out.print(key + " = " + value + "; "));
				System.out.println();
			}

			if (cliParser.isVerbose()) {
				System.out.println("Tempo de carregamento dos parâmetros: " + loadTime + "ms");
				System.out.println("Tempo de verificação da frase: " + analysisTime + "ms");
			}

		} catch (Exception e) {
			System.err.println("Ocorreu um erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
