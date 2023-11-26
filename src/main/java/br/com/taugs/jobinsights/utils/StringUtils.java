package br.com.taugs.jobinsights.utils;

import com.github.brutils.javabrutils.StringUtil;

public final class StringUtils {

	private StringUtils() {

	}

	public static String returnForLikeSearch(String str) {
		return "%" + HQLUtils.normalizer(StringUtil.nuloParaVazio(str).toUpperCase()) + "%";
	}

	public static Boolean isBlank(String str) {
		return str == null || str.isBlank() || str.isEmpty();
	}

}
