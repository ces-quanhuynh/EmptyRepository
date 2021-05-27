<%@ include file="../init.jsp" %>

<c:if test="<%= themeDisplay.isSignedIn()%>">
    <%
        renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.FALSE);
    %>
</c:if>

<%
    Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();
    birthdayCalendar.set(Calendar.MONTH,Calendar.JANUARY);
    birthdayCalendar.set(Calendar.DATE,1);
    birthdayCalendar.set(Calendar.YEAR,1970);
    List stateCodes = new ArrayList<String>(Arrays.asList("AK", "AL", "AR", "AS", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "GU", "HI", "IA",
            "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV",
            "NY", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY"
    ));
%>

<%--Basic Info--%>
<liferay-ui:error exception="<%= BasicInfoValidationException.FirstNameMustNotBeNull.class%>" message="exception.first-name-must-not-be-null"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.FirstNameMustBeCorrect.class%>" message="exception.first-name-must-be-correct"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.LastNameMustNotBeNull.class%>" message="exception.last-name-must-not-be-null"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.LastNameMustBeCorrect.class%>" message="exception.last-name-must-be-correct"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.EmailMustNotBeNull.class%>" message="exception.email-must-not-be-null"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.EmailMustBeCorrect.class%>" message="exception.email-must-be-correct"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.ScreenNameMustNotBeNull.class%>" message="exception.username-must-not-be-null"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.ScreenNameMustBeCorrect.class%>" message="exception.username-must-be-correct"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.BirthdayMustNotBeNull.class%>" message="exception.birthday-must-not-be-null"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.BirthdayMustBeCorrect.class%>" message="exception.birthday-is-not-enough"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.PasswordMustNotBeNull.class%>" message="exception.password-must-not-be-null"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.PasswordMustBeCorrect.class%>" message="exception.password-must-be-correct"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.ConfirmedPasswordMustNotBeNull.class%>" message="exception.confirmed-password-must-not-be-null"/>
<liferay-ui:error exception="<%= BasicInfoValidationException.ConfirmedPasswordMustBeCorrect.class%>" message="exception.confirmed-password-must-match-the-password"/>

<%--Phone--%>
<liferay-ui:error exception="<%= PhoneValidationException.MobilePhoneMustBeCorrect.class%>" message="exception.mobile-phone-numbers-must-be-10-digits"/>
<liferay-ui:error exception="<%= PhoneValidationException.HomePhoneMustBeCorrect.class%>" message="exception.home-phone-numbers-must-be-10-digits"/>

<%--Billing Address--%>
<liferay-ui:error exception="<%= BillingAddressValidationException.Address1MustNotBeNull.class%>" message="exception.address1-must-not-be-null"/>
<liferay-ui:error exception="<%= BillingAddressValidationException.Address1MustBeCorrect.class%>" message="exception.address1-must-be-correct"/>
<liferay-ui:error exception="<%= BillingAddressValidationException.Address2MustBeCorrect.class%>" message="exception.address2-must-be-correct"/>
<liferay-ui:error exception="<%= BillingAddressValidationException.CityMustNotBeNull.class%>" message="exception.city-must-not-be-null"/>
<liferay-ui:error exception="<%= BillingAddressValidationException.CityMustBeCorrect.class%>" message="exception.city-must-be-correct"/>
<liferay-ui:error exception="<%= BillingAddressValidationException.StateMustNotBeNull.class%>" message="exception.state-must-not-be-null"/>
<liferay-ui:error exception="<%= BillingAddressValidationException.ZipCodeMustNotBeNull.class%>" message="exception.zip-code-must-not-be-null"/>
<liferay-ui:error exception="<%= BillingAddressValidationException.ZipCodeMustBeCorrect.class%>" message="exception.zip-code-must-be-correct"/>

<%--Security Question--%>
<liferay-ui:error exception="<%= SecurityQuestionValidationException.AnswerMustNotBeNull.class%>" message="exception.security-answer-must-not-be-null"/>
<liferay-ui:error exception="<%= SecurityQuestionValidationException.AnswerMustBeCorrect.class%>" message="exception.security-answer-must-be-correct"/>

<portlet:actionURL name="<%= MVCCommandNames.ADD_USER_ENTRIES%>" var="addEntryURL" />

<aui:form action="${addEntryURL}" name="<portlet:namespace/>fm">

    <aui:fieldset column="<%=true%>">

        <aui:col width="<%=50%>">
            <h3>Basic Info</h3>

            <aui:input name="first_name" label="First Name" required="true"/>

            <aui:input name="last_name" label="Last Name" required="true"/>

            <aui:input name="email_address" label="Email Address" required="true"/>

            <aui:input name="username" label="Username" required="true"/>

            <aui:select name="male" label="gender" required="true">
                <aui:option label="male" value="1" />
                <aui:option label="female" value="0" />
            </aui:select>

            <c:choose>
                <c:when test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_BIRTHDAY) %>">
                    <aui:input model="<%= Contact.class %>" name="birthday" value="<%= birthdayCalendar %>" required="true"/>
                </c:when>
                <c:otherwise>
                    <aui:input model="<%= Contact.class %>" name="birthdayMoth" type="hidden" value="<%= Calendar.JANUARY %>"/>
                    <aui:input model="<%= Contact.class %>" name="birthdayDay" type="hidden" value="1"/>
                    <aui:input model="<%= Contact.class %>" name="birthdayYear" type="hidden" value="1970"/>
                </c:otherwise>
            </c:choose>

            <aui:input name="password1" label="Password" required="true" type="password"/>

            <aui:input name="password2" label="Confirm Password" required="true" type="password"/>

        </aui:col>

        <aui:col width="<%=50%>">

            <h3>Phone</h3>

            <aui:input name="home_phone" label="Home Phone"/>

            <aui:input name="mobile_phone" label="Mobile Phone"/>

            <br><h3>Billing Address(US-Only)</h3>

            <aui:input name="address" label="Address 1" required="true"/>

            <aui:input name="address2" label="Address 2"/>

            <aui:input name="city" label="City" required="true"/>

            <aui:select name="state" label="State" required="true">
                <c:forEach var="stateCode" items="<%=stateCodes%>">
                    <aui:option label="${stateCode}" value="${stateCode}"/>
                </c:forEach>
            </aui:select>

            <aui:input name="zip" label="Zip Code" required="true"/>

            <h3>Security Question</h3>

            <aui:select name="security_question" label="Security Question" required="true">
                <aui:option label="what-is-your-mother-s-maiden-name" value="what-is-your-mother-s-maiden-name" />
                <aui:option label="what-is-the-make-of-your-first-car" value="what-is-the-make-of-your-first-car" />
                <aui:option label="what-is-your-high-school-mascot" value="what-is-your-high-school-mascot" />
                <aui:option label="who-is-your-favorite-actor" value="who-is-your-favorite-actor" />
            </aui:select>

            <aui:input name="security_answer" label="Answer" required="true"/>

        </aui:col>

    </aui:fieldset>

    <aui:input name="Term of use" label="term.of.use" type="checkbox" required="true"/>

    <aui:button-row>
        <aui:button type="submit" />
    </aui:button-row>

</aui:form>