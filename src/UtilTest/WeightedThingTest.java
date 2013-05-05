/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilTest;

import java.util.PriorityQueue;
import org.junit.Test;
import Util.*;
import static org.junit.Assert.*;

/**
 *
 * @author Ben
 */
public class WeightedThingTest {

	@Test
	public void testPriorityQueue() {
		PriorityQueue<WeightedThing<Integer>> queue = new PriorityQueue();
		WeightedThing<Integer> thing1 = new WeightedThing<>(1, 8);
		WeightedThing<Integer> thing2 = new WeightedThing<>(2, 3);
		WeightedThing<Integer> thing3 = new WeightedThing<>(3, 5);

		queue.add(thing1);
		queue.add(thing2);
		queue.add(thing3);

		WeightedThing<Integer> poll1 = queue.poll();
		assert (2 == poll1.thing);
		WeightedThing<Integer> poll2 = queue.poll();
		assert (3 == poll2.thing);
		WeightedThing<Integer> poll3 = queue.poll();
		assert (1 == poll3.thing);

	}
}
