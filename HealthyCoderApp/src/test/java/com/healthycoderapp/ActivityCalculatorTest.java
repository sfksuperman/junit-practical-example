package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ActivityCalculatorTest {

	@Test
	void should_ReturnBad_When_AvgBelow20() {
		// given
		int weeklyCardioMins = 40;
		int weeklyWorkHours = 1;
		
		// when
		String actual = ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkHours);
		
		// then
		assertEquals("bad", actual);
	}
	
	@Test
	void should_ReturnAverage_When_AvgBetween20And40() {
		// given
		int weeklyCardioMins = 40;
		int weeklyWorkHours = 3;
		
		// when
		String actual = ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkHours);
		
		// then
		assertEquals("average", actual);
	}
	
	@Test
	void should_ReturnGood_When_AvgAbove40() {
		// given
		int weeklyCardioMins = 40;
		int weeklyWorkHours = 7;
		
		// when
		String actual = ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkHours);
		
		// then
		assertEquals("good", actual);
	}
	
	@Test
	void should_ThrowException_When_InputBelowZero() {
		// given
		int weeklyCardioMins = -40;
		int weeklyWorkHours = 7;
		
		// when
		Executable executable = () -> ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkHours);
		
		// then
		assertThrows(RuntimeException.class, executable);
	}

}
