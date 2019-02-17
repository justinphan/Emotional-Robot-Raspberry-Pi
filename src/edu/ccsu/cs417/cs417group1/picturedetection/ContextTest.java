package edu.ccsu.cs417.cs417group1.picturedetection;

import static org.junit.Assert.*;
import java.awt.Color;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

import org.junit.Test;

/*
 * @author Sonia Leonato
 * Tests for Context class
 */
public class ContextTest {
	
	Context context;
	Detection detection;
	
	@Test
	public void getObjectTest() {
		assertNotNull(context.getObject("path"));
	}
	
	@Test
	public void getColorTest() {
        assertNotNull(context.getColorAvg("path"));
	assertThat(context.getColorAvg("path"), instanceOf(Color.class));
	}

}
