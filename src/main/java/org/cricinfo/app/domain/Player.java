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
	private Integer spanFrom;
	private Integer spanTo;
	private Integer matches;
	private Integer innings;
	private Integer notOuts;
	private Integer runs;
	private String highest;
	private Float average;
	private Integer centuries;
	private Integer fifties;
	private Integer ducks;
	private String team;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSpanFrom() {
		return spanFrom;
	}

	public void setSpanFrom(Integer spanFrom) {
		this.spanFrom = spanFrom;
	}

	public Integer getSpanTo() {
		return spanTo;
	}

	public void setSpanTo(Integer spanTo) {
		this.spanTo = spanTo;
	}

	public Integer getMatches() {
		return matches;
	}

	public void setMatches(Integer matches) {
		this.matches = matches;
	}

	public Integer getInnings() {
		return innings;
	}

	public void setInnings(Integer innings) {
		this.innings = innings;
	}

	public Integer getNotOuts() {
		return notOuts;
	}

	public void setNotOuts(Integer notOuts) {
		this.notOuts = notOuts;
	}

	public Integer getRuns() {
		return runs;
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
	}

	public String getHighest() {
		return highest;
	}

	public void setHighest(String highest) {
		this.highest = highest;
	}

	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

	public Integer getCenturies() {
		return centuries;
	}

	public void setCenturies(Integer centuries) {
		this.centuries = centuries;
	}

	public Integer getFifties() {
		return fifties;
	}

	public void setFifties(Integer fifties) {
		this.fifties = fifties;
	}

	public Integer getDucks() {
		return ducks;
	}

	public void setDucks(Integer ducks) {
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
		return name;
	}

}
