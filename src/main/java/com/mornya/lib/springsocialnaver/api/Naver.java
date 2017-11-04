/*
 * @(#)Naver.java version 2017. 11. 5
 *
 * Copyright by mornya. All rights reserved. Since 2006.
 * This application is based by SAPP Solution.
 */
package com.mornya.lib.springsocialnaver.api;

import com.mornya.lib.springsocialnaver.api.abstracts.UserOperation;
import org.springframework.social.ApiBinding;

public interface Naver extends ApiBinding {
	UserOperation userOperation();
}
