package edu.ccsu.cs417.cs417group1.emotion;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/*
* @author Sonia Leonato
* Test Class for OptimistFactory
*/
public class PessimistFactoryTest {

	PessimistFactory pessimist;
	Color blue;

	@Test
	public void test() {
		blue = new Color(30);
		assertThat(pessimist.produceEmotion(blue), instanceOf(AbstractProduct.class));
	}

}
