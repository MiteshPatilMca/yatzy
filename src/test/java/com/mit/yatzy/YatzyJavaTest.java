package com.mit.yatzy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyJavaTest {

	@Test
	void testChance() {
		assertEquals(15, new YatzyJava(1, 2, 3, 4, 5).chance());
		assertEquals(16, new YatzyJava(3, 3, 4, 5, 1).chance());
	}

	@Test
	void testYatzy() {
		assertEquals(50, new YatzyJava(1, 1, 1, 1, 1).yatzy());
		assertEquals(50, new YatzyJava(6, 6, 6, 6, 6).yatzy());
		assertEquals(0, new YatzyJava(6, 6, 6, 6, 3).yatzy());
	}

	@Test
	void testScoreOnes() {
		assertEquals(2, new YatzyJava(1, 1, 3, 4, 5).scoreOnes());
		assertEquals(0, new YatzyJava(2, 3, 4, 5, 6).scoreOnes());
	}

	@Test
	void testScoreTwos() {
		assertEquals(4, new YatzyJava(1, 2, 2, 4, 5).scoreTwos());
		assertEquals(0, new YatzyJava(1, 3, 4, 5, 6).scoreTwos());
	}

	@Test
	void testScoreThrees() {
		assertEquals(6, new YatzyJava(1, 2, 3, 3, 5).scoreThrees());
		assertEquals(0, new YatzyJava(1, 2, 4, 5, 6).scoreThrees());
	}

	@Test
	void testScoreFours() {
		assertEquals(8, new YatzyJava(1, 2, 4, 4, 5).scoreFours());
		assertEquals(0, new YatzyJava(1, 2, 3, 5, 6).scoreFours());
	}

	@Test
	void testScoreFives() {
		assertEquals(10, new YatzyJava(4, 4, 4, 5, 5).scoreFives());
		assertEquals(15, new YatzyJava(4, 4, 5, 5, 5).scoreFives());
		assertEquals(20, new YatzyJava(4, 5, 5, 5, 5).scoreFives());
	}

	@Test
	void testScoreSixes() {
		assertEquals(12, new YatzyJava(1, 6, 6, 4, 5).scoreSixes());
		assertEquals(0, new YatzyJava(1, 2, 3, 4, 5).scoreSixes());
	}

	@Test
	void testScorePair() {
		assertEquals(6, new YatzyJava(3, 3, 4, 5, 6).scorePair());
		assertEquals(12, new YatzyJava(6, 6, 4, 5, 1).scorePair());
		assertEquals(12, new YatzyJava(6, 6, 6, 5, 1).scorePair());
		assertEquals(8, new YatzyJava(3, 3, 4, 4, 5).scorePair());
		assertEquals(0, new YatzyJava(1, 2, 3, 4, 5).scorePair());
	}

	@Test
	void testTwoPair() {
		assertEquals(16, new YatzyJava(3, 3, 5, 5, 2).twoPair());
		assertEquals(12, new YatzyJava(4, 4, 2, 2, 1).twoPair());
		assertEquals(0, new YatzyJava(3, 3, 3, 5, 1).twoPair());
		assertEquals(0, new YatzyJava(1, 2, 3, 4, 5).twoPair());
		assertEquals(0, new YatzyJava(6, 6, 6, 6, 1).twoPair());
	}

	@Test
	void testThreeOfAKind() {
		assertEquals(9, new YatzyJava(3, 3, 3, 4, 5).threeOfAKind());
		assertEquals(18, new YatzyJava(6, 6, 6, 4, 5).threeOfAKind());
		assertEquals(0, new YatzyJava(1, 2, 3, 4, 5).threeOfAKind());
	}

	@Test
	void testFourOfAKind() {
		assertEquals(12, new YatzyJava(3, 3, 3, 3, 5).fourOfAKind());
		assertEquals(24, new YatzyJava(6, 6, 6, 6, 1).fourOfAKind());
		assertEquals(0, new YatzyJava(1, 2, 3, 4, 5).fourOfAKind());
	}

	@Test
	void testSmallStraight() {
		assertEquals(15, new YatzyJava(1, 2, 3, 4, 5).smallStraight());
		assertEquals(15, new YatzyJava(5, 4, 3, 2, 1).smallStraight());
		assertEquals(0, new YatzyJava(1, 2, 3, 4, 6).smallStraight());
	}

	@Test
	void testLargeStraight() {
		assertEquals(20, new YatzyJava(2, 3, 4, 5, 6).largeStraight());
		assertEquals(20, new YatzyJava(6, 5, 4, 3, 2).largeStraight());
		assertEquals(0, new YatzyJava(1, 2, 3, 4, 5).largeStraight());
	}

	@Test
	void testFullHouse() {
		assertEquals(18, new YatzyJava(6, 2, 2, 2, 6).fullHouse());
		assertEquals(0, new YatzyJava(2, 3, 4, 5, 6).fullHouse());
	}
}