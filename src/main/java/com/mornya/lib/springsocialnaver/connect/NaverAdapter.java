/*
 * @(#)NaverAdapter.java version 2017. 11. 5
 *
 * Copyright by mornya. All rights reserved. Since 2006.
 * This application is based by SAPP Solution.
 */
package com.mornya.lib.springsocialnaver.connect;

import com.mornya.lib.springsocialnaver.api.abstracts.UserOperation;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import com.mornya.lib.springsocialnaver.api.Naver;

public final class NaverAdapter implements ApiAdapter<Naver> {
	public void setConnectionValues(final Naver naver, final ConnectionValues values) {
		final UserOperation userOperation = naver.userOperation();
		values.setProviderUserId(userOperation.getId());
		values.setProfileUrl("");
		values.setDisplayName(userOperation.getNickname());
		values.setImageUrl(userOperation.getProfile_image());
	}

	public UserProfile fetchUserProfile(final Naver naver) {
		return new UserProfileBuilder()
				.setEmail(naver.userOperation().getEmail())
				.setName(naver.userOperation().getName())
				.setUsername(naver.userOperation().getNickname())
				.build();
	}

	@Override
	public boolean test(final Naver api) {
		return false;
	}

	@Override
	public void updateStatus(final Naver api, final String message) {
	}
}
