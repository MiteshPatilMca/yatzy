package com.mit.yatzy;

public class YatzyJava {

	// Constants
	private static final int NUMBER_OF_DICE = 5;
	private static final int MIN_DIE_VALUE = 1;
	private static final int MAX_DIE_VALUE = 6;

	private final int[] dice;

	// Constructor
	public YatzyJava(int d1, int d2, int d3, int d4, int d5) {
		this.dice = new int[] { d1, d2, d3, d4, d5 };
	}

	// Method to get counts of each die value
	private int[] getDiceCounts() {
		int[] counts = new int[MAX_DIE_VALUE];
		for (int die : dice) {
			if (die >= MIN_DIE_VALUE && die <= MAX_DIE_VALUE) {
				counts[die - 1]++;
			}
		}
		return counts;
	}

	public int chance() {
		int total = 0;
		for (int die : dice) {
			total += die;
		}
		return total;
	}

	// Full Score
	public int yatzy() {
		int[] counts = getDiceCounts();
		for (int count : counts) {
			if (count == NUMBER_OF_DICE) {
				return 50;
			}
		}
		return 0;
	}

	// To get score
	public int scoreNumbers(int number) {
		int sum = 0;
		for (int die : dice) {
			if (die == number) {
				sum += number;
			}
		}
		return sum;
	}

	public int scoreOnes() {
		return scoreNumbers(1);
	}

	public int scoreTwos() {
		return scoreNumbers(2);
	}

	public int scoreThrees() {
		return scoreNumbers(3);
	}

	public int scoreFours() {
		return scoreNumbers(4);
	}

	public int scoreFives() {
		return scoreNumbers(5);
	}

	public int scoreSixes() {
		return scoreNumbers(6);
	}

	// One Pair numbers
	public int scorePair() {
		int[] counts = getDiceCounts();
		for (int i = MAX_DIE_VALUE - 1; i >= 0; i--) {
			if (counts[i] >= 2) {
				return (i + 1) * 2;
			}
		}
		return 0;
	}

	// Two Pair numbers
	public int twoPair() {
		int[] counts = getDiceCounts();
		int pairsFound = 0;
		int score = 0;
		for (int i = MAX_DIE_VALUE - 1; i >= 0; i--) {
			if (counts[i] >= 2) {
				pairsFound++;
				score += (i + 1) * 2;
			}
		}
		if (pairsFound == 2) {
			return score;
		}
		return 0;
	}

	// Three same numbers
	public int threeOfAKind() {
		int[] counts = getDiceCounts();
		for (int i = 0; i < MAX_DIE_VALUE; i++) {
			if (counts[i] >= 3) {
				return (i + 1) * 3;
			}
		}
		return 0;
	}

	// Four same numbers
	public int fourOfAKind() {
		int[] counts = getDiceCounts();
		for (int i = 0; i < MAX_DIE_VALUE; i++) {
			if (counts[i] >= 4) {
				return (i + 1) * 4;
			}
		}
		return 0;
	}

	// Count 1,2,3,4,5
	public int smallStraight() {
		int[] counts = getDiceCounts();
		boolean isSmallStraight = true;
		for (int i = 0; i < NUMBER_OF_DICE; i++) {
			if (counts[i] != 1) {
				isSmallStraight = false;
				break;
			}
		}
		return isSmallStraight ? 15 : 0;
	}

	// Count 2,3,4,5,6
	public int largeStraight() {
		int[] counts = getDiceCounts();
		boolean isLargeStraight = true;
		for (int i = 1; i < MAX_DIE_VALUE; i++) {
			if (counts[i] != 1) {
				isLargeStraight = false;
				break;
			}
		}
		return isLargeStraight ? 20 : 0;
	}

	public int fullHouse() {
		int[] counts = getDiceCounts();
		int pairValue = 0;
		int threeOfAKindValue = 0;

		for (int i = 0; i < MAX_DIE_VALUE; i++) {
			if (counts[i] == 2) {
				pairValue = i + 1;
			} else if (counts[i] == 3) {
				threeOfAKindValue = i + 1;
			}
		}

		if (pairValue > 0 && threeOfAKindValue > 0) {
			return (pairValue * 2) + (threeOfAKindValue * 3);
		}
		return 0;
	}

}