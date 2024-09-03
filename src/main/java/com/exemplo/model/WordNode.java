package com.exemplo.model;


import java.util.ArrayList;
import java.util.List;

public class WordNode {
    private String word;
    private int depth;
    private List<WordNode> subcategories;

    public WordNode() {
        this.subcategories = new ArrayList<WordNode>();
    }

    public WordNode(String word, int depth) {
        this.word = word;
        this.depth = depth;
        this.subcategories = new ArrayList<WordNode>();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public List<WordNode> getSubcategories() {
        return subcategories;
    }

    public void addSubcategory(WordNode subcategory) {
        this.subcategories.add(subcategory);
    }

    @Override
    public String toString() {
        return "WordNode{" +
                "word='" + word + '\'' +
                ", depth=" + depth +
                ", subcategories=" + subcategories +
                '}';
    }
}

