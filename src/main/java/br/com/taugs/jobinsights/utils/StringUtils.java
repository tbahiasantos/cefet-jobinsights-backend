package br.com.taugs.jobinsights.utils;

import com.github.brutils.javabrutils.StringUtil;

public final class StringUtils {

	private StringUtils() {

	}

	public static String returnForLikeSearch(String str) {
		return "%" + HQLUtils.normalizer(StringUtil.nuloParaVazio(str).toUpperCase()) + "%";
	}

}
