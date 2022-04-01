package com.example.interpreter;

public class MultiPageTransferCorrector implements ICorrect {
    @Override
    public String correct(String content) {
        return content.replaceAll("\\n+", "\n");
    }
}
