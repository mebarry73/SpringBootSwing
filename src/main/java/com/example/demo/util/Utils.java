package com.example.demo.util;

import java.util.List;

import com.example.demo.model.DoctorEntry;
import com.google.gson.Gson;

// define a functional interface
@FunctionalInterface
interface GetAsJson {
	String format(List<DoctorEntry> values);
}

public class Utils {
	public static String returnAsJson(List<DoctorEntry> values) {
		Gson gson = new Gson();
		// lambda expression
		GetAsJson lExpression = (List<DoctorEntry> list) -> gson.toJson(list);

		return lExpression.format(values);
	}
}
