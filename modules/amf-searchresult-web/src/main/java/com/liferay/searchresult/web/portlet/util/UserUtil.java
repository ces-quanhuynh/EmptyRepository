package com.liferay.searchresult.web.portlet.util;

import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserUtil {

    public static List<Address> getAddressesByZip(long companyId, String zip) {
        List<Address> listAddresses = AddressLocalServiceUtil.getAddresses();

        return listAddresses.stream().filter(address -> address.getCompanyId() == companyId && address.getZip().equals(zip)).collect(Collectors.toList());
    }

    public static int getUserByZipCodeCount(long companyId, String zip) {
        List<Address> listAddressesByZip = getAddressesByZip(companyId, zip);
        List<User> listUsersByZip = new ArrayList<>();
        List<User> listUsersByZipReturn = new ArrayList<>();

        for (Address address : listAddressesByZip) {
            User user = UserLocalServiceUtil.fetchUser(address.getUserId());
            if (!listUsersByZip.contains(user)) {
                listUsersByZip.add(user);
            }
        }

        return listUsersByZip.size();
    }

    public static List<User> getUsersByZipCode(long companyId, int start, int end, String zip) {
        List<Address> listAddressesByZip = getAddressesByZip(companyId, zip);
        List<User> listUsersByZip = new ArrayList<>();
        List<User> listUsersByZipReturn = new ArrayList<>();

        for (Address address : listAddressesByZip) {
            User user = UserLocalServiceUtil.fetchUser(address.getUserId());
            if (!listUsersByZip.contains(user)) {
                listUsersByZip.add(user);
            }
        }

        int listUserByZipSize = listUsersByZip.size();

        if (start >= listUserByZipSize) {
            for (int userIndex = 0; userIndex < listUserByZipSize; userIndex++) {
                listUsersByZipReturn.add(listUsersByZip.get(userIndex));
            }
        }
        if (end >= listUserByZipSize) {
            for (int userIndex = start; userIndex < listUserByZipSize; userIndex++) {
                listUsersByZipReturn.add(listUsersByZip.get(userIndex));
            }
        } else {
            for (int userIndex = start; userIndex < end; userIndex++) {
                listUsersByZipReturn.add(listUsersByZip.get(userIndex));
            }
        }

        return listUsersByZipReturn;

    }
}
