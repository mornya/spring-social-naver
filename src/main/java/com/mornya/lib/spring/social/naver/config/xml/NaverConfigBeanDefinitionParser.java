/*
 * @(#)NaverConfigBeanDefinitionParser.java version 2017. 11. 5
 *
 * Copyright by mornya. All rights reserved. Since 2006.
 * This application is based by SAPP Solution.
 */
package com.mornya.lib.spring.social.naver.config.xml;

import com.mornya.lib.spring.social.naver.connect.NaverConnectionFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import com.mornya.lib.spring.social.naver.config.support.NaverApiHelper;
import org.springframework.social.security.provider.SocialAuthenticationService;

import java.util.Map;

public final class NaverConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {
	public NaverConfigBeanDefinitionParser() {
		super(NaverConnectionFactory.class, NaverApiHelper.class);
	}

	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
		return NaverConnectionFactory.NaverAuthenticationService.class;
	}

	@Override
	protected BeanDefinition getConnectionFactoryBeanDefinition(String appId, String appSecret, Map<String, Object> allAttributes) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder
				.genericBeanDefinition(NaverConnectionFactory.class)
				.addConstructorArgValue(appId);
		return builder.getBeanDefinition();
	}
}
