package com.example.interpreter;

public class OddSpaceCorrector implements ICorrect {
    @Override
    public String correct(String content) {
        return content.replaceAll(" (?=[),.])", "").replaceAll("(?<=[(]) ", "");
    }
}
