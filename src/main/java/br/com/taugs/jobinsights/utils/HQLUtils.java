package br.com.taugs.jobinsights.utils;

import java.text.Normalizer;

public final class HQLUtils {

	private HQLUtils() {

	}

	public static String normalizer(String s) {
		return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

}
