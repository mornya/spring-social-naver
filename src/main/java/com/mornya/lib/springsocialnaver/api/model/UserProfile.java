/*
 * @(#)UserProfile.java version 2017. 11. 5
 *
 * Copyright by mornya. All rights reserved. Since 2006.
 * This application is based by SAPP Solution.
 */
package com.mornya.lib.springsocialnaver.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "data")
public class UserProfile extends Model implements Serializable {
	private static final long serialVersionUID = 4399788025738419513L;

	private UserProfileResult result;
	private UserProfileResponse response;

	public UserProfileResult getResult() {
		return result;
	}

	public void setResult(UserProfileResult result) {
		this.result = result;
	}

	public UserProfileResponse getResponse() {
		return response;
	}

	public void setResponse(UserProfileResponse response) {
		this.response = response;
	}
}
