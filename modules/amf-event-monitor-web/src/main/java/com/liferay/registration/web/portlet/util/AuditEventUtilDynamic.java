package com.liferay.registration.web.portlet.util;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.stream.Collectors;

@Component(immediate = true, service = AuditEventUtilDynamic.class)
public class AuditEventUtilDynamic {

    private Order order = OrderFactoryUtil.desc("createDate");

    public List<AuditEvent> getAuditEvents(long companyId, int start, int end) throws JSONException {

        DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("companyId",companyId))
                .addOrder(order);

        return editAssignUserInformationEventList(_auditEventLocalService.dynamicQuery(dynamicQuery,start,end));
    }

    public List<AuditEvent> getAuditEventsByType(long companyId, int start, int end, String type) throws JSONException {

        if(type.equals("REGISTRATION")){
            return editAssignUsersInformationEvent(companyId);
        }

        DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("companyId",companyId))
                .add(RestrictionsFactoryUtil.eq("eventType",type))
                .addOrder(order);

        return _auditEventLocalService.dynamicQuery(dynamicQuery,start,end);
    }

    public List<AuditEvent> getAuditEventsByUserId(long companyId, int start, int end, long userId) throws JSONException {
        DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("companyId",companyId))
                .add(RestrictionsFactoryUtil.eq("userId",userId))
                .addOrder(order);

        return _auditEventLocalService.dynamicQuery(dynamicQuery,start,end);
    }

    public List<AuditEvent> getAuditEventsByUserIdAndType(long companyId, int start, int end, String type, long userId) throws JSONException {

        if(type.equals("REGISTRATION")){
            return  editAssignUsersInformationEvent(companyId).stream().filter(auditEvent -> auditEvent.getUserId()==userId).collect(Collectors.toList());
        }

        DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("companyId",companyId))
                .add(RestrictionsFactoryUtil.eq("userId",userId))
                .add(RestrictionsFactoryUtil.eq("eventType",type))
                .addOrder(order);

        return _auditEventLocalService.dynamicQuery(dynamicQuery,start,end);
    }

    public int getAuditEventsCount(long companyId){
        DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("companyId",companyId));
        return _auditEventLocalService.dynamicQuery(dynamicQuery).size();
    }

    public int getAuditEventCountByType(long companyId, String type){

        if(type.equals("REGISTRATION")){
            DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery()
                    .add(RestrictionsFactoryUtil.eq("companyId",companyId))
                    .add(RestrictionsFactoryUtil.eq("eventType","ADD"));

            return _auditEventLocalService.dynamicQuery(dynamicQuery).size();
        }

        DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("companyId",companyId))
                .add(RestrictionsFactoryUtil.eq("eventType",type));

        return _auditEventLocalService.dynamicQuery(dynamicQuery).size();
    }

    public int getAuditEventsCountByUserId(long companyId,long userId){
        DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("companyId",companyId))
                .add(RestrictionsFactoryUtil.eq("userId",userId));

        return _auditEventLocalService.dynamicQuery(dynamicQuery).size();
    }

    public int getAuditEventsCountByTypeAndUserId(long companyId,String type, long userId){
        DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("companyId",companyId))
                .add(RestrictionsFactoryUtil.eq("userId",userId))
                .add(RestrictionsFactoryUtil.eq("eventType",type));

        return _auditEventLocalService.dynamicQuery(dynamicQuery).size();
    }


    //add userId and userName for 3 auditEvent after register the account
    private List<AuditEvent> editAssignUserInformationEventList(List<AuditEvent> list) throws JSONException {
        for(int editIndex = 0; editIndex < list.size(); editIndex++){
            if(list.get(editIndex).getUserId()==0 && list.get(editIndex).getEventType().equals("ADD")){
                String additionalInfo = list.get(editIndex).getAdditionalInfo();
                editAssignUserInformationEvent(additionalInfo,list.get(editIndex),list.get(editIndex-1),list.get(editIndex-2));
            }
        }
        return list;
    }

    //using the information in the additionalInformation field in DB to fill the userId field and userName field
    private void editAssignUserInformationEvent(String additionalInfo, AuditEvent... auditEvents ) throws JSONException {
        JSONObject object = JSONFactoryUtil.createJSONObject(additionalInfo);
        for(AuditEvent auditEvent:auditEvents){
            auditEvent.setUserId(Long.parseLong(object.getString("userId")));
            auditEvent.setUserName(object.getString("userName"));
            auditEvent.setClientIP("0.0.0.0");
            if(auditEvent.getEventType().equals("ADD")){
                auditEvent.setEventType("REGISTRATION");
            }
        }
    }

    //find and edit AuditEvent from ADD to REGISTRATION to show exactly
    private List<AuditEvent> editAssignUsersInformationEvent(long companyId) throws JSONException {
        DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("companyId",companyId))
                .add(RestrictionsFactoryUtil.eq("eventType","ADD"))
                .addOrder(order);

        List<AuditEvent> listRegistration = _auditEventLocalService.dynamicQuery(dynamicQuery);
        for (AuditEvent auditEvent:listRegistration){
            JSONObject object = JSONFactoryUtil.createJSONObject(auditEvent.getAdditionalInfo());

            auditEvent.setUserId(Long.parseLong(object.getString("userId")));
            auditEvent.setUserName(object.getString("userName"));
            auditEvent.setClientIP("0.0.0.0");
            auditEvent.setEventType("REGISTRATION");
        }

        return  listRegistration;
    }

    @Reference
    private AuditEventLocalService _auditEventLocalService;
}
