/*
 * @(#)NaverConnectionFactory.java version 2017. 11. 5
 *
 * Copyright by mornya. All rights reserved. Since 2006.
 * This application is based by SAPP Solution.
 */
package com.mornya.lib.spring.social.naver.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import com.mornya.lib.spring.social.naver.api.Naver;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

public final class NaverConnectionFactory extends OAuth2ConnectionFactory<Naver> {
	public NaverConnectionFactory(final String clientId, final String clientSecret) {
		super("naver", new NaverServiceProvider(clientId, clientSecret), new NaverAdapter());
	}

	public static class NaverAuthenticationService extends OAuth2AuthenticationService<Naver> {
		public NaverAuthenticationService(final String clientId, final String clientSecret) {
			super(new NaverConnectionFactory(clientId, clientSecret));
		}
	}
}
