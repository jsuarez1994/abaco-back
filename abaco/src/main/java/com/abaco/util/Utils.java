package com.abaco.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	/**
	 * Obtenemos el mes a partir del periodo
	 * @param period
	 * @return String
	 */
	public String getMonthByPeriod(String period) {
		return StringUtils.trimToNull(period.substring(4));
	}

}
