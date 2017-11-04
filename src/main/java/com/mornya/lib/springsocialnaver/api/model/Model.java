/*
 * @(#)Model.java version 2017. 11. 5
 *
 * Copyright by mornya. All rights reserved. Since 2006.
 * This application is based by SAPP Solution.
 */
package com.mornya.lib.springsocialnaver.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Model {
	public String toJson(boolean prettyPrint) {
		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			if (prettyPrint) {
				return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			} else {
				return objectMapper.writeValueAsString(this);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
}
