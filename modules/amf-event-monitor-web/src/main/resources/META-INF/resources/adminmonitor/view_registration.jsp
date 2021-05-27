<%@ include file="../init.jsp" %>

<p>VIEW REGISTRATION</p>

<%
    OrderByComparator<AuditEvent> comparator = OrderByComparatorFactoryUtil.create("Audit_AuditEvent","createDate","desc");
%>

<c:choose>
    <c:when test="<%=AdminMonitorPermission.contains(permissionChecker,company.getCompanyId(),ActionKeys.PERMISSIONS)%>">
        <liferay-ui:search-container total="<%=AuditEventUtil.getAuditEventsCountByType(company.getCompanyId(),"REGISTRATION",comparator)%>"
                                     id="registrationAuditEvent" emptyResultsMessage="Empty">
            <liferay-ui:search-container-results results="<%=AuditEventUtil.getAuditEventsByEventType(company.getCompanyId(),searchContainer.getStart(),
			searchContainer.getEnd(),comparator,"REGISTRATION")%>"/>

            <liferay-ui:search-container-row
                    className="com.liferay.portal.security.audit.AuditEvent" keyProperty="userId" modelVar="entry">

                <liferay-ui:search-container-column-text name="Date" value="${entry.createDate}" />

                <liferay-ui:search-container-column-text name="userName" value="${entry.userName}" />

                <liferay-ui:search-container-column-text name="userId" value="${entry.userId}" />

                <liferay-ui:search-container-column-text name="clientIP" value="${entry.clientIP}" />

                <liferay-ui:search-container-column-text name="eventType" value="${entry.eventType}" />

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator />

        </liferay-ui:search-container>
    </c:when>
    <c:otherwise>
        <liferay-ui:search-container total="<%=AuditEventUtil.getAuditEventsCountByTypeAndUserId(company.getCompanyId(),"REGISTRATION",themeDisplay.getUserId(),
        comparator)%>" id="registrationAuditEvent" emptyResultsMessage="Empty">
            <liferay-ui:search-container-results results="<%=AuditEventUtil.getAuditEventsByTypeAndUserId(company.getCompanyId(),searchContainer.getStart(),
			searchContainer.getEnd(),comparator,"REGISTRATION",themeDisplay.getUserId())%>"/>

            <liferay-ui:search-container-row
                    className="com.liferay.portal.security.audit.AuditEvent" keyProperty="userId" modelVar="entry">

                <liferay-ui:search-container-column-text name="Date" value="${entry.createDate}" />

                <liferay-ui:search-container-column-text name="userName" value="${entry.userName}" />

                <liferay-ui:search-container-column-text name="userId" value="${entry.userId}" />

                <liferay-ui:search-container-column-text name="clientIP" value="${entry.clientIP}" />

                <liferay-ui:search-container-column-text name="eventType" value="${entry.eventType}" />

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator />

        </liferay-ui:search-container>
    </c:otherwise>
</c:choose>