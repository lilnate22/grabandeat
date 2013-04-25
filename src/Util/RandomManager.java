/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Random;

/**
 *
 * @author Ben
 */
public class RandomManager extends Random {

	public static RandomManager curRandom;

	public RandomManager(int seed) {
		super(seed);
	}
}
