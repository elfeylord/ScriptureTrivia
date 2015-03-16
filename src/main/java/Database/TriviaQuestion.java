/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cole
 */
public class TriviaQuestion {
    private String question;
    private String correctA;
    private String wrongA1;
    private String wrongA2;
    private String wrongA3;
    
    public TriviaQuestion(String question, String correct, String one, String two, String three) {
    this.question = question;
    correctA = correct;
    wrongA1 = one;
    wrongA2 = two;
    wrongA3 = three;
}

    public List<String> getAnswerList()
    {
        List<String> sendList = new ArrayList();
        
        sendList.add(correctA);
        sendList.add(wrongA1);
        sendList.add(wrongA2);
        sendList.add(wrongA3);
        return sendList;
    }

    public String getQuestion() {
        return question;
    }
    
    public String getCorrectA() {
        return correctA;
    }

    public String getWrongA1() {
        return wrongA1;
    }

    public String getWrongA2() {
        return wrongA2;
    }

    public String getWrongA3() {
        return wrongA3;
    }
    
    
}
