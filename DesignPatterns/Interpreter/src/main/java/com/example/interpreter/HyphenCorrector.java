package com.example.interpreter;

public class HyphenCorrector implements ICorrect{

    @Override
    public String correct(String content) {
        return content.replaceAll(" -", " —");
    }
}
