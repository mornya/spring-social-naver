/*
 * @(#)NaverApi.java version 2017. 11. 5
 *
 * Copyright by mornya. All rights reserved. Since 2006.
 * This application is based by SAPP Solution.
 */
package com.mornya.lib.springsocialnaver.api.util;

import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;

public final class NaverApi {
	private static final String API_HOST_USER = "https://apis.naver.com";
	private static final MultiValueMap<String, String> EMPTY_PARAMETER = new LinkedMultiValueMap<String, String>();

	public static URI buildUri(final String host, final String path, final MultiValueMap<String, String> parameters) {
		return URIBuilder.fromUri(host + path).queryParams(parameters).build();
	}

	public static URI buildUserUri(final String path) {
		return buildUri(API_HOST_USER, path, EMPTY_PARAMETER);
	}
}
