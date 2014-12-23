package org.cricinfo.app;

import static java.lang.System.out;
import static org.cricinfo.app.data.DataGenerator.batsmen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.cricinfo.app.data.DataGenerator;
import org.cricinfo.app.domain.Player;

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
		out.println(app.runsMoreThan(10000));
		out.println(app.mostRunGetterByTeam("India"));
		out.println(app.mostRunsOrderByTeam());
		
		List<Integer> greaterThan3 = Arrays.asList(3, 4, 5, 7, 1, 2, 9, 8, 44, 4, 6, 2, 3, 1, 0)
				.stream()
				.filter(num -> num > 3)
				.map(num -> num * 2)
				.collect(Collectors.toList());
		System.out.println(greaterThan3);
	}

	private void getPlayerWithMostRuns() {
		String batsman = batsmen.stream()
				.max(Comparator.comparing(player -> player.getRuns()))
				.map(player -> player.getName()).get();
		out.println("Most runs by : " + batsman);
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
				.map(player -> player.getName()).get();
		return playerName;
	}

	private Map<String, Optional<Player>> mostRunsOrderByTeam() {
		Map<String, Optional<Player>> map = batsmen.stream().collect(
				Collectors.groupingBy(player -> player.getTeam(), Collectors
						.maxBy(Comparator.comparing(player -> ((Player) player)
								.getRuns()))));
		return map;
	}
}
