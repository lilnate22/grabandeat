/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Ben
 */
public class WeightedThing<t> implements Comparable<WeightedThing> {

	public final t thing;
	public final int weight;

	public WeightedThing(t thing, int weight) {
		this.thing = thing;
		this.weight = weight;
	}

	@Override
	public int compareTo(WeightedThing t) {
		return weight - t.weight;
	}
}
