package com.example.interpreter;

import java.util.ArrayList;

public class MainCorrector implements ICorrect {
    private final ArrayList<ICorrect> corrects;

    MainCorrector(){
        corrects = new ArrayList<>();
        corrects.add(new TabulatorCorrector());
        corrects.add(new HyphenCorrector());
        corrects.add(new QuotesCorrector());
        corrects.add(new MultiPageTransferCorrector());
        corrects.add(new MultiSpaceCorrector());
        corrects.add(new OddSpaceCorrector());
    }
    @Override
    public String correct(String content) {
        for(ICorrect correct : corrects) {
            content = correct.correct(content);
        }
        return content;
    }
}
