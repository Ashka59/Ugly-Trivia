package com.adaptionsoft.games.trivia;


import org.junit.jupiter.api.Test;

import com.adaptionsoft.games.uglytrivia.QuestionCategory;
import com.adaptionsoft.games.uglytrivia.Questions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;


public class QuestionsTest {
    
    private Questions questions;

    @BeforeEach
    public void setUp() {
		questions = new Questions();
    }
    
  
    @Test
    void testCurrentCategory() {
		assertTrue(questions.currentCategory(0) == QuestionCategory.Pop);
		assertTrue(questions.currentCategory(1) == QuestionCategory.Science);
		assertTrue(questions.currentCategory(2) == QuestionCategory.Sports);
		assertTrue(questions.currentCategory(3) == QuestionCategory.Rock);
    }

	
    @Test
    void testCurrentCategoryWithNullValue() {
		assertThrows(NullPointerException.class, () -> questions.currentCategory((Integer) null));
    }

    @Test
    void testGetNextQuestion() {
		assertEquals(questions.getNextQuestion(0), "Pop Question 0");
		assertEquals(questions.getNextQuestion(1), "Science Question 0");
		assertEquals(questions.getNextQuestion(2), "Sports Question 0");
		assertEquals(questions.getNextQuestion(3), "Rock Question 0");		
    }

    @Test
    void testGetNextQuestionWithNullValue() {
		assertThrows(NullPointerException.class, () -> questions.getNextQuestion((Integer) null));
    }
}
