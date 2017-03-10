package cn.tju.scs.wyh;

import static org.junit.Assert.*;

import org.junit.Test;

public class Triangle_test {
	public Triangle triangle = new Triangle();
	@Test
	public void test() {
		assertEquals(1, triangle.isTri(1, 1, 1));
		assertEquals(2, triangle.isTri(2, 2, 3));
		assertEquals(3, triangle.isTri(3, 4, 5));
		assertEquals(0, triangle.isTri(5, 6, 7));
		assertEquals(0, triangle.isTri(5, 6, 7));
		assertEquals(0, triangle.isTri(5, 7, 6));
		assertEquals(0, triangle.isTri(7, 6, 5));
		assertEquals(-1, triangle.isTri(2, 1, 1));
	}
}
