package com.exemplo.service;

import java.io.File;
import java.io.IOException;

import com.exemplo.model.WordNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HierarchyLoader {

	public WordNode loadHierarchy(String filePath) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(filePath), WordNode.class);
	}

}
