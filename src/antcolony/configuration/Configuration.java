/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antcolony.configuration;

import Util.Vector2;
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author Ben
 */
public class Configuration implements Serializable, Cloneable {

	public static Configuration currentConfig = new Configuration();

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	// TODO add save and load
	//Graphics options
	public Vector2 resolution = new Vector2(800, 600);
	public int FPS = 60; //frames per second
	//Simulation configs
	public int antCount = 30;
	public int boardSize = 30;//what a square side's count'll be
	public int wallCount = 80;
	public int randomSeed = 489784; //I googled "The most random number" and it turns out it's 17
	public int iterations = 10;
	public int stepSize = 400;
//	public int maxHistory = 200;
	//weights and stuff
	public int pheromoneDegradeRate = 2;
	public int pheromoneWeight = 229;
	public int randomWeight = 30;
	public float momentumWeight = 3.4940798f;
	public int hivePheromoneValue = 79;
	public int foodValue = 218;
	public float squareCorrectionFactor = 1.414f;
	//colors 
	public Color antsColor = Color.BLUE;
	public Color wallColor = Color.BLACK;
	public Color foodColor = Color.GREEN;
	public Color foodTrailColor = Color.ORANGE;
	public Color homeTrailColor = Color.YELLOW;
	public Color hiveColor = Color.MAGENTA;
	public Color backColor = Color.LIGHT_GRAY;

	public void save() throws IOException {
		Yaml yaml = new Yaml();
		String fileName = this.hashCode() + ".cfg";
		FileWriter writer = new FileWriter(fileName);
		yaml.dump(this, writer);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Configuration other = (Configuration) obj;
		if (!Objects.equals(this.resolution, other.resolution)) {
			return false;
		}
		if (this.FPS != other.FPS) {
			return false;
		}
		if (this.antCount != other.antCount) {
			return false;
		}
		if (this.boardSize != other.boardSize) {
			return false;
		}
		if (this.wallCount != other.wallCount) {
			return false;
		}
		if (this.randomSeed != other.randomSeed) {
			return false;
		}
		if (this.iterations != other.iterations) {
			return false;
		}
		if (this.stepSize != other.stepSize) {
			return false;
		}
		if (this.pheromoneDegradeRate != other.pheromoneDegradeRate) {
			return false;
		}
		if (this.pheromoneWeight != other.pheromoneWeight) {
			return false;
		}
		if (this.randomWeight != other.randomWeight) {
			return false;
		}
		if (Float.floatToIntBits(this.momentumWeight) != Float.floatToIntBits(other.momentumWeight)) {
			return false;
		}
		if (this.hivePheromoneValue != other.hivePheromoneValue) {
			return false;
		}
		if (this.foodValue != other.foodValue) {
			return false;
		}
		if (Float.floatToIntBits(this.squareCorrectionFactor) != Float.floatToIntBits(other.squareCorrectionFactor)) {
			return false;
		}
		if (!Objects.equals(this.antsColor, other.antsColor)) {
			return false;
		}
		if (!Objects.equals(this.wallColor, other.wallColor)) {
			return false;
		}
		if (!Objects.equals(this.foodColor, other.foodColor)) {
			return false;
		}
		if (!Objects.equals(this.foodTrailColor, other.foodTrailColor)) {
			return false;
		}
		if (!Objects.equals(this.homeTrailColor, other.homeTrailColor)) {
			return false;
		}
		if (!Objects.equals(this.hiveColor, other.hiveColor)) {
			return false;
		}
		if (!Objects.equals(this.backColor, other.backColor)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 53 * hash + Objects.hashCode(this.resolution);
		hash = 53 * hash + this.FPS;
		hash = 53 * hash + this.antCount;
		hash = 53 * hash + this.boardSize;
		hash = 53 * hash + this.wallCount;
		hash = 53 * hash + this.randomSeed;
		hash = 53 * hash + this.iterations;
		hash = 53 * hash + this.stepSize;
		hash = 53 * hash + this.pheromoneDegradeRate;
		hash = 53 * hash + this.pheromoneWeight;
		hash = 53 * hash + this.randomWeight;
		hash = 53 * hash + Float.floatToIntBits(this.momentumWeight);
		hash = 53 * hash + this.hivePheromoneValue;
		hash = 53 * hash + this.foodValue;
		hash = 53 * hash + Float.floatToIntBits(this.squareCorrectionFactor);
		hash = 53 * hash + Objects.hashCode(this.antsColor);
		hash = 53 * hash + Objects.hashCode(this.wallColor);
		hash = 53 * hash + Objects.hashCode(this.foodColor);
		hash = 53 * hash + Objects.hashCode(this.foodTrailColor);
		hash = 53 * hash + Objects.hashCode(this.homeTrailColor);
		hash = 53 * hash + Objects.hashCode(this.hiveColor);
		hash = 53 * hash + Objects.hashCode(this.backColor);
		return hash;
	}
}
