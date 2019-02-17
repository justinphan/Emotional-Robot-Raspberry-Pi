package edu.ccsu.cs417.cs417group1.emotion;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/*
* @author Sonia Leonato
* Test Class for OptimistFactory
*/
public class OptimistFactoryTest {

	OptimistFactory optimist;
	Color red;

	@Test
	public void test() {
		red = new Color(50);
		assertThat(optimist.produceEmotion(red), instanceOf(AbstractProduct.class));
		
	}

}
