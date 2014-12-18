package org.cricinfo.app.domain;

/**
 * 
 * @author jeevan
 * @date 18-Dec-2014
 * @purpose 
 *
 */
public class Player {
	private String name;
	private String span;
	private int matches;
	private int innings;
	private int notOuts;
	private int runs;
	private String highest;
	private float average;
	private int centuries;
	private int fifties;
	private int ducks;
	private String team;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpan() {
		return span;
	}

	public void setSpan(String span) {
		this.span = span;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getInnings() {
		return innings;
	}

	public void setInnings(int innings) {
		this.innings = innings;
	}

	public int getNotOuts() {
		return notOuts;
	}

	public void setNotOuts(int notOuts) {
		this.notOuts = notOuts;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public String getHighest() {
		return highest;
	}

	public void setHighest(String highest) {
		this.highest = highest;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	public int getCenturies() {
		return centuries;
	}

	public void setCenturies(int centuries) {
		this.centuries = centuries;
	}

	public int getFifties() {
		return fifties;
	}

	public void setFifties(int fifties) {
		this.fifties = fifties;
	}

	public int getDucks() {
		return ducks;
	}

	public void setDucks(int ducks) {
		this.ducks = ducks;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", team=" + team + "]";
	}

}
