package org.cricinfo.app;

import java.util.List;

import org.cricinfo.app.data.DataGenerator;
import static org.cricinfo.app.data.DataGenerator.batsmen;

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
		batsmen.stream()
			   .forEach(System.out::println);
	}
}
