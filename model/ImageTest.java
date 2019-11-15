package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImageTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testImage() {
		Image imgOne = new Image(5, "interior", "purple", "monsterFlash");

		equals(imgOne.equals(getClass()));
	}

	@Test
	void testGetId() {
		Image imgOne = new Image(5, "interior", "purple", "monsterFlash");
		assertEquals(imgOne.getId(), 5);
	}

	@Test
	/**
	 * this test checks if the requested value is correctly change
	 */
	void testSetId() {
		Image imgOne = new Image(5, "interior", "purple", "monsterFlash");
		imgOne.setId(3);
		assertEquals(imgOne.getId(), 3);
	}

	@Test
	/**
	 * this test checks if the requested value is correct
	 */
	void testGetType() {

		Image imgOne = new Image(5, "interior", "purple", "monsterFlash");
		assertEquals(imgOne.getType(), "purple");
	}

	@Test
	/**
	 * after set this test checks that the value has changed
	 */
	void testSetType() {
		Image imgOne = new Image(5, "interior", "purple", "monsterFlash");
		imgOne.setType("exterior");
		assertEquals(imgOne.getType(), "exterior");
	}

	@Test
	/**
	 * this test checks that the String at least is outputting
	 */
	void testToString() {
		Image imgOne = new Image(5, "interior", "purple", "monsterFlash");

		String toString = imgOne.toString();
		assertTrue(toString.contains("interior"));
		assertFalse(toString.contains("win"));
		assertTrue(toString.contains("purple"));
		assertTrue(toString.contains("5"));

	}

}
