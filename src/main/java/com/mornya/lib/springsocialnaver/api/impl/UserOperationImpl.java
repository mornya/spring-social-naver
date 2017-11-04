/*
 * @(#)UserOperationImpl.java version 2017. 11. 5
 *
 * Copyright by mornya. All rights reserved. Since 2006.
 * This application is based by SAPP Solution.
 */
package com.mornya.lib.springsocialnaver.api.impl;

import com.mornya.lib.springsocialnaver.api.model.UserProfileResponse;
import com.mornya.lib.springsocialnaver.api.util.NaverApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.InvalidAuthorizationException;
import org.springframework.social.MissingAuthorizationException;
import com.mornya.lib.springsocialnaver.api.abstracts.UserOperation;
import com.mornya.lib.springsocialnaver.api.model.UserProfile;
import org.springframework.web.client.RestTemplate;

public class UserOperationImpl implements UserOperation {
	private static final Logger LOG = LoggerFactory.getLogger(UserOperationImpl.class);

	private boolean isAuthorized;
	private UserProfile userProfile;

	public UserOperationImpl(RestTemplate restTemplate, boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
		this.userProfile = restTemplate.getForObject(NaverApi.buildUserUri("/nidlogin/nid/getUserProfile.xml"), UserProfile.class);
	}

	private UserProfileResponse getUserProfile() {
		if (this.isAuthorized) {
			if (!"00".equals(this.userProfile.getResult().getResultcode())) {
				throw new InvalidAuthorizationException("naver", this.userProfile.getResult().getMessage());
			}
			if (LOG.isDebugEnabled()) {
				LOG.debug("USER PROFILE RESULT: {}", this.userProfile.toJson(false));
			}
			return this.userProfile.getResponse();
		} else {
			throw new MissingAuthorizationException("naver");
		}
	}

	@Override
	public String getId() {
		return getUserProfile().getId();
	}

	@Override
	public String getNickname() {
		return getUserProfile().getNickname();
	}

	@Override
	public String getName() {
		return getUserProfile().getName();
	}

	@Override
	public String getEmail() {
		return getUserProfile().getEmail();
	}

	@Override
	public String getGender() {
		return getUserProfile().getGender();
	}

	@Override
	public String getAge() {
		return getUserProfile().getAge();
	}

	@Override
	public String getBirthday() {
		return getUserProfile().getBirthday();
	}

	@Override
	public String getProfile_image() {
		return getUserProfile().getProfile_image();
	}
}
