package com.example.week01_lab_20010211_huynhminhthu.services;


import com.example.week01_lab_20010211_huynhminhthu.models.GrantAccess;
import com.example.week01_lab_20010211_huynhminhthu.repositories.GrantAccessRepository;

import java.util.List;

public class GrantAccessServices {
    private static GrantAccessRepository grantAccessDao = new GrantAccessRepository();

    public static void insertGrantAccess(GrantAccess grantAccess) {
        grantAccessDao.insertGrantAccess(grantAccess);
    }

    public static GrantAccess searchGrantAccessByAccountId(String id) {
        return grantAccessDao.searchGrantAccessByAccountId(id);
    }

    public static List<GrantAccess> getListGrantAccess() {
        return grantAccessDao.getListGrantAccess();
    }
}