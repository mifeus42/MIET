package com.example.interpreter;

public class MultiSpaceCorrector implements ICorrect{
    @Override
    public String correct(String content) {
        return content.replaceAll(" +", " ");
    }
}
