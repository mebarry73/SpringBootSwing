package com.example.demo.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.util.ResourceUtils;

public class ImportCSV {

	public ImportCSV() {
		try {
			importPersons();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void importPersons() throws FileNotFoundException {
		List<List<String>> records = new ArrayList<>();
		File file = ResourceUtils.getFile("classpath:Persons.csv");
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		}
		System.err.println("count " + records.size());
	}

	private void importDoctors() throws FileNotFoundException {

	}

	private List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(Constants.CSV_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	}
}
