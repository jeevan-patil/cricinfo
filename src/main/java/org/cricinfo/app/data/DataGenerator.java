package org.cricinfo.app.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.cricinfo.app.domain.Player;

import au.com.bytecode.opencsv.CSVReader;

/**
 * 
 * @author jeevan
 *
 */
public class DataGenerator {

	public static List<Player> batsmen = new ArrayList<Player>();
	
	public void readBattingRecords() {
		InputStream stream = null;
		try {
			stream = new FileInputStream(getClass().getClassLoader().getResource("cric_batting_records.csv").getFile());
			CSVReader reader = new CSVReader(new InputStreamReader(stream, "UTF-8"));
			List<String[]> content = reader.readAll();

			String[] row = null;

			int cnt = 0;
			for (Object object : content) {
				row = (String[]) object;

				if(cnt != 0) {
					Player player = new Player();
					player.setName(row[0]);
					player.setSpan(row[1]);
					player.setMatches(Integer.valueOf(row[2].replace("*", "")));
					player.setInnings(Integer.valueOf(row[3]));
					player.setNotOuts(Integer.valueOf(row[4]));
					player.setRuns(Integer.valueOf(row[5]));
					player.setHighest(row[6]);
					player.setAverage(Float.valueOf(row[7]));
					player.setCenturies(Integer.valueOf(row[8]));
					player.setFifties(Integer.valueOf(row[9]));
					player.setDucks(Integer.valueOf(row[10]));
					player.setTeam(row[11]);
					batsmen.add(player);
				}
				++cnt;
			}
			reader.close();
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (UnsupportedEncodingException uex) {
			uex.printStackTrace();
		} catch(Exception e) {
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
}
