/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.registration.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.registration.model.UserEntry;
import com.liferay.registration.service.base.UserEntryLocalServiceBaseImpl;

import com.liferay.registration.validator.BasicInfoValidator;
import com.liferay.registration.validator.BillingAddressValidator;
import com.liferay.registration.validator.PhoneValidator;
import com.liferay.registration.validator.SecurityQuestionValidator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

/**
 * The implementation of the user entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.registration.service.UserEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author quanhuynh
 * @see UserEntryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.registration.model.UserEntry",
	service = AopService.class
)
public class UserEntryLocalServiceImpl extends UserEntryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.registration.service.UserEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.registration.service.UserEntryLocalServiceUtil</code>.
	 */
	public UserEntry addUserEntry(long creatorUserId, long companyId, boolean autoPassword, String password1, String password2,
								  boolean autoScreenName, String screenName, String emailAddress, long facebookId,
								  String openId, Locale locale, String firstName, String middleName, String lastName,
								  long prefixId, long suffixId, boolean male, int birthdayMonth, int birthdayDay, int birthdayYear,
								  String jobTitle, long[] groupIds, long[] organizationIds, long[] roleIds, long[] userGroupIds,
								  boolean sendEmail, String homePhone, String mobilePhone, String address1, String address2,
								  String city, String state, String zipCode, String securityQuestion, String securityAnswer,
								  ServiceContext serviceContext) throws PortalException {

		long userEntryId = counterLocalService.increment();

		UserEntry userEntry = userEntryPersistence.create(userEntryId);

		User user = _userLocalService.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1, password2,
				autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName,
				prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
				roleIds, groupIds, sendEmail, serviceContext);

		_basicInfoValidator.validate(firstName,lastName,emailAddress,screenName,birthdayMonth,birthdayDay,birthdayYear,password1,password2);
		_phoneValidator.validate(homePhone,mobilePhone);
		_billingAddressValidator.validate(address1,address2,city,state,zipCode);
		_seSecurityQuestionValidator.validate(securityAnswer);

		_userLocalService.updateReminderQuery(user.getUserId(),securityQuestion,securityAnswer);

		userEntry.setUuid(serviceContext.getUuid());
		userEntry.setHomePhone(homePhone);
		userEntry.setMobilePhone(mobilePhone);
		userEntry.setAddress1(address1);
		userEntry.setAddress1(address2);
		userEntry.setCity(city);
		userEntry.setState(state);
		userEntry.setZipCode(zipCode);
		userEntry.setUserId(user.getUserId());

		userEntryPersistence.update(userEntry);

		return userEntry;
	}

	@Reference
	private UserLocalService _userLocalService;

	@Reference
	private BasicInfoValidator _basicInfoValidator;

	@Reference
	private PhoneValidator _phoneValidator;

	@Reference
	private BillingAddressValidator _billingAddressValidator;

	@Reference
	private SecurityQuestionValidator _seSecurityQuestionValidator;
}