package com.example.interpreter;

public class QuotesCorrector implements ICorrect {
    @Override
    public String correct(String content) {

        return content.replaceAll(" \"", "«").replaceAll("\"", "»");
    }
}
