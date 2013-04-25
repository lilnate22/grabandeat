/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.Serializable;

/**
 *
 * @author Ben
 */
public class Vector2 implements Serializable {

	public int x, y;

	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Vector2() {
		x = 0;
		y = 0;
	}

	public Vector2(Vector2 other) {
		x = other.x;
		y = other.y;
	}

	public void add(Vector2 other) {
		this.x += other.x;
		this.y += other.y;
	}
	public final static Vector2 WEST = new Vector2(-1, 0);
	public final static Vector2 SOUTHWEST = new Vector2(-1, 1);
	public final static Vector2 NORTHWEST = new Vector2(-1, -1);
	public final static Vector2 NORTH = new Vector2(0, -1);
	public final static Vector2 EAST = new Vector2(1, 0);
	public final static Vector2 NORTHEAST = new Vector2(1, -1);
	public final static Vector2 SOUTHEAST = new Vector2(1, 1);
	public final static Vector2 SOUTH = new Vector2(0, 1);

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Vector2)) {
			return false;
		}
		Vector2 other = (Vector2) o;
		if (other.x == x && other.y == y) {
			return true;
		}
		return false;

	}
}
