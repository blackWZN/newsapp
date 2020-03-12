package newsapp;

import java.util.Random;

import org.junit.Test;

public class NewsAppTest {
	@Test
	public void test() {
		  StringBuffer result = new StringBuffer();
	        for(int i=0;i<6;i++) {
	            result.append(Integer.toHexString(new Random().nextInt(16)));
	        }
	        System.out.println(result.toString().toUpperCase());
	}
}
