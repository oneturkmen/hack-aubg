package com.example.quizapp;

/**
 * Class that contains information about a question and answers to it
 */
public class Question {
    private Integer id;
    private String question;
    private String correct_answer;
    private String answer2;
    private String answer3;
    private String answer4;

    /**
     * Inject the information from XML into Question class (with answers)
     *
     * @param id - unique identification
     * @param correct_answer - first answer is always correct one
     * @param answer2 - second answer (should be incorrect)
     * @param answer3 - third answer (should be incorrect)
     * @param answer4 - fourth answer (should be incorrect)
     */
    public Question(int id, String question, String correct_answer,
                    String answer2, String answer3, String answer4) {
        this.id = id;
        this.question = question;
        this.correct_answer = correct_answer;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    /**
     * Getter for unique id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Getter for question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Getter for correct answer
     */
    public String getCorrectAnswer() {
        return correct_answer;
    }

    /**
     * Getter for second (incorrect) answer
     */
    public String getAnswer2() {
        return answer2;
    }

    /**
     * Getter for third (incorrect) answer
     */
    public String getAnswer3() {
        return answer3;
    }

    /**
     * Getter for fourth (incorrect) answer
     */
    public String getAnswer4() {
        return answer4;
    }

    /**
     * Returns every info (question + answer)
     * FOR TESTING PURPOSES
     */
    public String getAllInfo() {
        return this.id + " " + this.question +
                " " + this.correct_answer +
                " " + this.answer2 +
                " " + this.answer3 +
                " " + this.answer4;
    }
}
