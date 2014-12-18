package org.cricinfo.app;

import static org.cricinfo.app.data.DataGenerator.batsmen;

import java.util.Comparator;

import org.cricinfo.app.data.DataGenerator;

/**
 * 
 * @author jeevan
 * @date 18-Dec-2014
 * @purpose 
 *
 */
public class App {
	public static void main(String[] args) {
		new DataGenerator().readBattingRecords();

		App app = new App();
		app.getPlayerWithMostRuns();
	}

	private void getPlayerWithMostRuns() {
		String batsman = batsmen.stream()
								.max(Comparator.comparing(player -> player.getRuns()))
								.map(player -> player.getName())
								.get();
		System.out.println("Most runs by : " + batsman);
	}
}
