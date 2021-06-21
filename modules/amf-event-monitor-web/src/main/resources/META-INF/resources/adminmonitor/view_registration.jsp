<%@ include file="../init.jsp" %>

<p>VIEW REGISTRATION</p>

<%
    AuditEventUtilDynamic auditEventUtilDynamic = (AuditEventUtilDynamic) renderRequest.getAttribute("audit");
%>

<c:choose>
    <c:when test="<%=AdminMonitorPermission.contains(permissionChecker,company.getCompanyId(),ActionKeys.PERMISSIONS)%>">
        <liferay-ui:search-container total="<%=auditEventUtilDynamic.getAuditEventCountByType(company.getCompanyId(),"ASSIGN")%>"
                                     id="registrationAuditEvent" emptyResultsMessage="Empty">
            <liferay-ui:search-container-results results="<%=auditEventUtilDynamic.getAuditEventsByType(company.getCompanyId(),searchContainer.getStart(),
			searchContainer.getEnd(),"REGISTRATION")%>"/>

            <liferay-ui:search-container-row
                    className="com.liferay.portal.security.audit.storage.model.AuditEvent" keyProperty="userId" modelVar="entry">

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
        <liferay-ui:search-container total="<%=auditEventUtilDynamic.getAuditEventsCountByTypeAndUserId(company.getCompanyId(),"REGISTRATION",themeDisplay.getUserId())%>"
                                     id="registrationAuditEvent" emptyResultsMessage="Empty">
            <liferay-ui:search-container-results results="<%=auditEventUtilDynamic.getAuditEventsByUserIdAndType(company.getCompanyId(),searchContainer.getStart(),
			searchContainer.getEnd(),"REGISTRATION",themeDisplay.getUserId())%>"/>

            <liferay-ui:search-container-row
                    className="com.liferay.portal.security.audit.storage.model.AuditEvent" keyProperty="userId" modelVar="entry">

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