package com.liferay.registration.web.permission.resource;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.registration.web.constants.AdminMonitorPortletKeys;
import org.osgi.service.component.annotations.Component;

@Component(immediate=true)
public class AdminMonitorPermission {
    public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {

        return permissionChecker.hasPermission(groupId, AdminMonitorPortletKeys.ADMINMONITOR,groupId, actionId);

    }
}
