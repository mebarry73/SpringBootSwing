package com.example.demo.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.util.ResourceUtils;

import lombok.extern.java.Log;

@Log
public class ImportCSV {

	private static ImportCSV INSTANCE;

	private ImportCSV() {
	}

	public static ImportCSV getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ImportCSV();
		}
		return INSTANCE;
	}

	public void importPersons() throws FileNotFoundException {
		List<List<String>> records = new ArrayList<>();
		File file = ResourceUtils.getFile("classpath:Persons.csv");
		try (var scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String nextLine = scanner.nextLine();
				log.info(nextLine);
				records.add(getRecordFromLine(nextLine));
			}
		}
		log.info("count " + records.size());
	}

	private List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (var rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(Constants.CSV_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	}
}
