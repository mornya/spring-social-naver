/*
 * @(#)UserOperation.java version 2017. 11. 5
 *
 * Copyright by mornya. All rights reserved. Since 2006.
 * This application is based by SAPP Solution.
 */
package com.mornya.lib.springsocialnaver.api.abstracts;

public interface UserOperation {
	String getId();
	String getNickname();
	String getName();
	String getEmail();
	String getGender();
	String getAge();
	String getBirthday();
	String getProfile_image();
}
