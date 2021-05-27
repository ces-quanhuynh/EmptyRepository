package com.liferay.registration.web.portlet.util;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.security.audit.AuditEventManager;
import com.liferay.portal.security.audit.AuditEvent;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component(immediate = true, service = {})
public class AuditEventUtil {

    public static AuditEvent fetchAuditEvent(long auditEventId) {
        return  _auditEventManager.fetchAuditEvent(auditEventId);
    }

    public static List<AuditEvent> getAuditEvents(long companyId, int start, int end,
                                                  OrderByComparator orderByComparator) throws JSONException {

        return editAssignUserInformationEventList(_auditEventManager.getAuditEvents(
                companyId, start, end, orderByComparator));
    }

    public static List<AuditEvent> getAuditEvents(
            long companyId, long userId, String userName, Date createDateGT,
            Date createDateLT, String eventType, String className, String classPK,
            String clientHost, String clientIP, String serverName, int serverPort,
            String sessionID, boolean andSearch, int start, int end,
            OrderByComparator orderByComparator) {

        return _auditEventManager.getAuditEvents(
                companyId, userId, userName, createDateGT, createDateLT, eventType,
                className, classPK, clientHost, clientIP, serverName, serverPort,
                sessionID, andSearch, start, end, orderByComparator);
    }

    public static int getAuditEventsCount(long companyId) {
        return _auditEventManager.getAuditEventsCount(companyId);
    }

    public static int getAuditEventsCountByType(long companyId, String eventType, OrderByComparator orderByComparator) throws JSONException {
        List<AuditEvent> auditEventList = getAuditEvents(companyId,0,getAuditEventsCount(companyId),orderByComparator);
        return (int)auditEventList.stream().filter(auditEvent -> auditEvent.getEventType().equals(eventType)).count();
    }

    public static int getAuditEventsCountByUserId(long companyId, long userId, OrderByComparator orderByComparator) throws JSONException {
        List<AuditEvent> auditEventList = getAuditEvents(companyId,0,getAuditEventsCount(companyId),orderByComparator);
        return (int)auditEventList.stream().filter(auditEvent -> auditEvent.getUserId()==userId).count();
    }

    public static int getAuditEventsCountByTypeAndUserId(long companyId, String eventType, long userId, OrderByComparator orderByComparator) throws JSONException {
        List<AuditEvent> auditEventList = getAuditEvents(companyId,0,getAuditEventsCount(companyId),orderByComparator);
        return (int)auditEventList.stream().filter(auditEvent -> auditEvent.getEventType().equals(eventType)&& auditEvent.getUserId()==userId).count();
    }

    public static int getAuditEventsCount(
            long companyId, long userId, String userName, Date createDateGT,
            Date createDateLT, String eventType, String className, String classPK,
            String clientHost, String clientIP, String serverName, int serverPort,
            String sessionID, boolean andSearch) {

        return _auditEventManager.getAuditEventsCount(
                companyId, userId, userName, createDateGT, createDateLT, eventType,
                className, classPK, clientHost, clientIP, serverName, serverPort,
                sessionID, andSearch);
    }

    public static List<AuditEvent> getAuditEventsByEventType(long companyId, int start, int end,
                                                             OrderByComparator orderByComparator, String eventType) throws JSONException {

        List<AuditEvent> auditEventList = getAuditEvents(companyId,0,getAuditEventsCount(companyId),orderByComparator);
        List<AuditEvent> auditEventListReturn = new ArrayList<>();

        List<AuditEvent> auditEventListByType = auditEventList.stream().filter(
                auditEvent -> auditEvent.getEventType().equals(eventType)
        ).collect(Collectors.toList());

        int listSize = auditEventListByType.size();

        if(start>=listSize){
            for(int auditEventIndex = 0; auditEventIndex<listSize;auditEventIndex++){
                auditEventListReturn.add(auditEventListByType.get(auditEventIndex));
            }
        }
        if(end>=listSize){
            for(int auditEventIndex = start; auditEventIndex<listSize;auditEventIndex++){
                auditEventListReturn.add(auditEventListByType.get(auditEventIndex));
            }
        } else {
            for(int auditEventIndex = start; auditEventIndex<end;auditEventIndex++){
                auditEventListReturn.add(auditEventListByType.get(auditEventIndex));
            }
        }

        return auditEventListReturn;
    }

    public static List<AuditEvent> getAuditEventsByUserId(long companyId, int start, int end,
                                                          OrderByComparator orderByComparator, long userId) throws JSONException {

        List<AuditEvent> auditEventList = getAuditEvents(companyId,0,getAuditEventsCount(companyId),orderByComparator);

        List<AuditEvent> auditEventListByUserId = auditEventList.stream().filter(
                auditEvent -> auditEvent.getUserId()==userId
        ).collect(Collectors.toList());

        List<AuditEvent> auditEventListReturn = new ArrayList<>();

        int listSize = auditEventListByUserId.size();

        if(start>=listSize){
            for(int auditEventIndex = 0; auditEventIndex<listSize;auditEventIndex++){
                auditEventListReturn.add(auditEventListByUserId.get(auditEventIndex));
            }
        }
        if(end>=listSize){
            for(int auditEventIndex = start; auditEventIndex<listSize;auditEventIndex++){
                auditEventListReturn.add(auditEventListByUserId.get(auditEventIndex));
            }
        } else {
            for(int auditEventIndex = start; auditEventIndex<end;auditEventIndex++){
                auditEventListReturn.add(auditEventListByUserId.get(auditEventIndex));
            }
        }

        return auditEventListReturn;
    }

    public static List<AuditEvent> getAuditEventsByTypeAndUserId(long companyId, int start, int end,
                                                                 OrderByComparator orderByComparator, String eventType, long userId ) throws JSONException {

        List<AuditEvent> auditEventListByUserId = getAuditEventsByUserId(companyId,0,getAuditEventsCount(companyId),
                orderByComparator,userId);

        List<AuditEvent> auditEventListReturn = new ArrayList<>();

        List<AuditEvent> auditEventListByType = auditEventListByUserId.stream().filter(
                auditEvent -> auditEvent.getEventType().equals(eventType)
        ).collect(Collectors.toList());

        int listSize = auditEventListByType.size();

        if(start>=listSize){
            for(int auditEventIndex = 0; auditEventIndex<listSize;auditEventIndex++){
                auditEventListReturn.add(auditEventListByType.get(auditEventIndex));
            }
        }
        if(end>=listSize){
            for(int auditEventIndex = start; auditEventIndex<listSize;auditEventIndex++){
                auditEventListReturn.add(auditEventListByType.get(auditEventIndex));
            }
        } else {
            for(int auditEventIndex = start; auditEventIndex<end;auditEventIndex++){
                auditEventListReturn.add(auditEventListByType.get(auditEventIndex));
            }
        }

        return auditEventListReturn;
    }

    //add userId and userName for 3 auditEvent after register the account
    private static List<AuditEvent> editAssignUserInformationEventList(List<AuditEvent> list) throws JSONException {
        for(int editIndex = 0; editIndex < list.size(); editIndex++){
            if(list.get(editIndex).getUserId()==0 && list.get(editIndex).getEventType().equals("ADD")){
                String additionalInfo = list.get(editIndex).getAdditionalInfo();
                editAssignUserInformationEvent(additionalInfo,list.get(editIndex),list.get(editIndex-1),list.get(editIndex-2));
            }
        }
        return list;
    }

    //using the information in the additionalInfor field in DB to fill the userId field and userName field
    private static void editAssignUserInformationEvent(String additionalInfo, AuditEvent... auditEvents ) throws JSONException {
        JSONObject object = JSONFactoryUtil.createJSONObject(additionalInfo);
        for(AuditEvent auditEvent:auditEvents){
            auditEvent.setUserId(Long.parseLong(object.getString("userId")));
            auditEvent.setUserName(object.getString("userName"));
            auditEvent.setClientIP("0.0.0.0");
            if(auditEvent.getEventType().equals("ASSIGN")){
                auditEvent.setEventType("REGISTRATION");
            }
        }
    }

    @Reference(unbind = "-")
    protected void set_auditEventManager(AuditEventManager auditEventManager) {
        _auditEventManager = auditEventManager;
    }

    private static AuditEventManager _auditEventManager;
}
