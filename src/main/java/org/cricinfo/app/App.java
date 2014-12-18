package org.cricinfo.app;

import static org.cricinfo.app.data.DataGenerator.batsmen;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		System.out.println(app.runsMoreThan(10000));
		System.out.println(app.mostRunGetterByTeam("India"));
	}

	private void getPlayerWithMostRuns() {
		String batsman = batsmen.stream()
				.max(Comparator.comparing(player -> player.getRuns()))
				.map(player -> player.getName()).get();
		System.out.println("Most runs by : " + batsman);
	}

	private List<String> runsMoreThan(int runs) {
		List<String> players = batsmen.stream()
				.filter(player -> (player.getRuns() > runs))
				.map(player -> player.getName()).collect(Collectors.toList());
		return players;
	}

	private String mostRunGetterByTeam(String team) {
		String playerName = batsmen.stream()
				.filter(player -> (player.getTeam().equals(team)))
				.max(Comparator.comparing(player -> player.getRuns()))
				.map(player -> player.getName())
				.get();
		return playerName;
	}

	private void mostRunsOrderByTeam() {
		Map<String, String> map = batsmen
				.stream()
				.sorted((p1, p2) -> p2.getRuns().compareTo(p1.getRuns()))
				.limit(1)
				.collect(Collectors.toMap(player -> player.getTeam(), player -> player.getName()));
		System.out.println(map);
	}
}
