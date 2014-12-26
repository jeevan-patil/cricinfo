package org.cricinfo.app.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.cricinfo.app.domain.Player;

import au.com.bytecode.opencsv.CSVReader;

/**
 * 
 * @author jeevan
 * @date 18-Dec-2014
 * @purpose
 *
 */
public class DataGenerator {

	public static List<Player> players = new ArrayList<Player>();

	public void readBattingRecords() {
		InputStream stream = null;
		try {
			stream = new FileInputStream(getClass().getClassLoader().getResource("cric_batting_records.csv").getFile());
			CSVReader reader = new CSVReader(new InputStreamReader(stream, "UTF-8"));
			List<String[]> content = reader.readAll();

			content.stream().skip(1).forEach(data -> {
				players.add(buildPlayer(data));
			});

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException ie) {
				}
			}
		}
	}

	private static Player buildPlayer(String[] data) {
		Player player = new Player();
		player.setName(data[0]);
		player.setSpanFrom(Integer.valueOf(data[1]));
		player.setSpanTo(Integer.valueOf(data[2]));
		player.setMatches(Integer.valueOf(data[3].replace("*", "")));
		player.setInnings(Integer.valueOf(data[4]));
		player.setNotOuts(Integer.valueOf(data[5]));
		player.setRuns(Integer.valueOf(data[6]));
		player.setHighest(data[7]);
		player.setAverage(Float.valueOf(data[8]));
		player.setCenturies(Integer.valueOf(data[9]));
		player.setFifties(Integer.valueOf(data[10]));
		player.setDucks(Integer.valueOf(data[11]));
		player.setTeam(data[12]);
		return player;
	}
}
