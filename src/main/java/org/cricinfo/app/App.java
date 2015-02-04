package org.cricinfo.app;

import static java.lang.System.out;
import static org.cricinfo.app.data.DataGenerator.players;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

		// get top N number of players with longest tenure
		out.println(app.playersWithLongestTenure(5));
		app.mostMatchesPlayedPerTeam();
	}

	private void mostMatchesPlayedPerTeam() {
		Comparator<Player> comparator = Comparator.comparing(player -> player.getRuns());
		Map<String, List<Player>> maxMatchesPerTeam = players.stream()
											.map(player -> player.getTeam())
											.distinct()
											.collect(Collectors.toMap(team -> team, 
														team -> players.stream()
																.filter(player -> (player.getTeam().equals(team)))
																.sorted(comparator.reversed())
																.limit(1)
																.collect(Collectors.toList())));
		
		System.out.println(maxMatchesPerTeam);
		
	}

	private void getPlayerWithMostRuns() {
		String batsman = players.stream()
				.max(Comparator.comparing(player -> player.getRuns()))
				.map(player -> player.getName()).get();
		out.println("Most runs by : " + batsman);
	}

	private List<String> runsMoreThan(int runs) {
		List<String> playersList = players.stream()
				.filter(player -> (player.getRuns() > runs))
				.map(player -> player.getName()).collect(Collectors.toList());
		return playersList;
	}

	private String mostRunGetterByTeam(String team) {
		String playerName = players.stream()
				.filter(player -> (player.getTeam().equals(team)))
				.max(Comparator.comparing(player -> player.getRuns()))
				.map(player -> player.getName()).get();
		return playerName;
	}

	private Map<String, Optional<Player>> mostRunsOrderByTeam() {
		Map<String, Optional<Player>> map = players.stream().collect(
				Collectors.groupingBy(player -> player.getTeam(), Collectors
						.maxBy(Comparator.comparing(player -> ((Player) player)
								.getRuns()))));
		return map;
	}

	/**
	 * In this method we are creating Supplier object of Stream. We can use this Supplier Stream multiple times.
	 * Ordinary Stream can only be used once.
	 */
	private Map<String, Integer> playersWithLongestTenure(int limit) {
		Comparator<Player> comparator = Comparator.comparing(player -> (player.getSpanTo() - player.getSpanFrom()));
		Supplier<Stream<Player>> supp = () -> players.stream()
				.sorted(comparator.reversed())
				.limit(limit);

		Map<String, Integer> dataMap = supp.get()
				.collect(Collectors.toMap(player -> ((Player) player).getName(), player -> (((Player) player).getSpanTo() - ((Player) player).getSpanFrom())));
		return dataMap;
	}
}
