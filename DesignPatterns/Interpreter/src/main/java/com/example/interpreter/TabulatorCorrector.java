package com.example.interpreter;

public class TabulatorCorrector implements ICorrect{

    @Override
    public String correct(String content) {
        return content.replaceAll("\\t+", "\t").replaceAll("\\t$", "").replaceAll("(?<=\\S)\\t", " ");
    }
}
