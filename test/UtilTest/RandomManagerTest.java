/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilTest;
import org.junit.Test;
import Util.*;
import static org.junit.Assert.*;
/**
 *
 * @author Ben
 */
public class RandomManagerTest {
	
	@Test
	public void testRandom(){
		RandomManager manager =new RandomManager(5);
		RandomManager.curRandom = manager;
		
		int a = manager.nextInt();
		int b = manager.nextInt();
		System.out.println(a);
		System.out.println(b);
		assertEquals(a, -1157408321);
		assertEquals(b, 758500184);
		assertNotSame(a, b);
	}
}
