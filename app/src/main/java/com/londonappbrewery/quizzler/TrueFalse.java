package com.londonappbrewery.quizzler;

public class TrueFalse {
    private int QuestionId;
    private boolean Answer;

    public TrueFalse(int questionId, boolean answer)
    {
        QuestionId=questionId;
        Answer=answer;
    }

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int questionId) {
        QuestionId = questionId;
    }

    public boolean getAnswer() {
        return Answer;
    }

    public void setAnswer(boolean answer) {
        Answer = answer;
    }

}
