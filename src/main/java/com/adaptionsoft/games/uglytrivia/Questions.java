package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Questions {

	private static final int NUMBER_OF_QUESTIONS = 50;
    private final LinkedList<String> popQuestions = new LinkedList<String>();
	private final LinkedList<String> scienceQuestions = new LinkedList<String>();
	private final LinkedList<String> sportsQuestions = new LinkedList<String>();
	private final LinkedList<String> rockQuestions = new LinkedList<String>();

	public Questions() {
		
		for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast("Science Question " + i);
			sportsQuestions.addLast("Sports Question " + i);
			rockQuestions.addLast("Rock Question " + i);
		}
	}

	public QuestionCategory currentCategory(int index) {
		switch (index %4) {
			case 0:
				return QuestionCategory.Pop;
			case 1:
				return QuestionCategory.Science;
			case 2:
				return QuestionCategory.Sports;
			case 3:
				return QuestionCategory.Rock;
			default:
				throw new NullPointerException("Unexpected value: " + index);
		}
	}

	public String getNextQuestion(int index) {
		switch (currentCategory(index)) {
		case Pop:
			return popQuestions.removeFirst();
		case Science:
			return scienceQuestions.removeFirst();
		case Sports:
			return sportsQuestions.removeFirst();
		case Rock:
			return rockQuestions.removeFirst();
		default:
			throw new NullPointerException("Unexpected value: " + currentCategory(index));
		}
	}
}