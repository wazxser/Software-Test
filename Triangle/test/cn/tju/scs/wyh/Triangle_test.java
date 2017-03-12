package cn.tju.scs.wyh;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Triangle_test{
	private int input1;
	private int input2;
	private int input3;
	private int expected;
	private Triangle triangle = null;
	
	public Triangle_test(int input1, int input2, int input3, int expected){
		this.input1 = input1;
		this.input2 = input2;
		this.input3 = input3;
		this.expected = expected;
	}
	
	@Before
	public void setUp(){
		triangle = new Triangle();
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
			{5, 6, 7, 0},
			{6, 7, 5, 0},
			{7, 6, 5, 0},
			{1, 1, 2, -1},
			{2, 2, 3, 2},
			{1, 1, 1, 1},
			{3, 4, 5, 3}
		});
	}
	
	@Test
	public void testIsTri(){
		assertEquals(this.expected, triangle.isTri(this.input1, this.input2, this.input3));
	}
}
