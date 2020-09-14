package com.pellegrini.code.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	public static String getCurrentTimestamp() {
		LocalDateTime timestamp = LocalDateTime.now();
		return timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
}
