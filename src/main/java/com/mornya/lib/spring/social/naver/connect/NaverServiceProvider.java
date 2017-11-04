/*
 * @(#)NaverServiceProvider.java version 2017. 11. 5
 *
 * Copyright by mornya. All rights reserved. Since 2006.
 * This application is based by SAPP Solution.
 */
package com.mornya.lib.spring.social.naver.connect;

import com.mornya.lib.spring.social.naver.api.Naver;
import com.mornya.lib.spring.social.naver.api.NaverOAuth2ApiBinding;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

public final class NaverServiceProvider extends AbstractOAuth2ServiceProvider<Naver> {
	public NaverServiceProvider(final String clientId, final String clientSecret) {
		super(new NaverOAuth2Template(clientId, clientSecret));
	}

	public Naver getApi(final String accessToken) {
		return new NaverOAuth2ApiBinding(accessToken);
	}
}
