package cn.tju.scs.wyh;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.Test;

import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

public class Primes_test {
	ByteArrayOutputStream out;
	PrintStream ps;
	ByteInputStream in = new ByteInputStream();
	
	public Primes primes = new Primes();
	int [] print = {2, 3, 5};
	
	@Before
	public void setUp(){
		out = new ByteArrayOutputStream();
		ps = new PrintStream(out);
		System.setOut(ps);
	}
	
	@Test
	public void test() throws IOException {
		out.flush();
		primes.printPrimes(3);
		assertEquals("Prime: 2\r\nPrime: 3\r\nPrime: 5\r\n", out.toString());
	}
}
