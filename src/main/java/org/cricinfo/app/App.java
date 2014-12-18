package org.cricinfo.app;

import java.util.List;

import org.cricinfo.app.data.DataGenerator;

public class App {
	public static void main(String[] args) {
		new DataGenerator().readBattingRecords();
	}

	private List<String> getPlayersWithMostRuns() {
		
	}
}
