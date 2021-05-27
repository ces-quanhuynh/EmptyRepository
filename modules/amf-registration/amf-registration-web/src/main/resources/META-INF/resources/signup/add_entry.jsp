<%@ include file="../init.jsp" %>

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