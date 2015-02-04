package org.cricinfo.app;

import java.util.List;

import org.cricinfo.app.data.DataGenerator;
import static org.cricinfo.app.data.DataGenerator.players;

public class StreamTest {

	public static void main(String a[]) {
		new DataGenerator().readBattingRecords();
		StreamTest app = new StreamTest();
		System.out.println(app.mostRunGetterByTeam("India"));
	}

	private List<String> mostRunGetterByTeam(String string) {
		return null;
	}
}
