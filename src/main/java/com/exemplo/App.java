package com.exemplo;

import com.exemplo.model.WordNode;
import com.exemplo.service.HierarchyLoader;
import com.exemplo.util.CLIParser;

public class App {
	public static void main(String[] args) {
		try {
			CLIParser cliParser = new CLIParser(args);

			String filePath = "dicts/hierarchy.json";
			HierarchyLoader loader = new HierarchyLoader();
			WordNode root = loader.loadHierarchy(filePath);

			cliParser.executeAnalysis(root);

		} catch (Exception e) {
			System.err.println("Ocorreu um erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
