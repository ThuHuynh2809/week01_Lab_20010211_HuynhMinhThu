package com.example.week01_lab_20010211_huynhminhthu.mapping;


import com.example.week01_lab_20010211_huynhminhthu.models.Account;
import com.example.week01_lab_20010211_huynhminhthu.models.GrantAccess;
import com.example.week01_lab_20010211_huynhminhthu.models.Role;
import com.example.week01_lab_20010211_huynhminhthu.services.AccountServices;
import com.example.week01_lab_20010211_huynhminhthu.services.GrantAccessServices;
import com.example.week01_lab_20010211_huynhminhthu.services.RoleServices;

public class GrantAccessServices_Test {
    public static void main(String[] args) {
        Account account1 = AccountServices.getAccounts().get(0);
        Account account2 = AccountServices.getAccounts().get(1);
        Role role1 = RoleServices.getRoles().get(0);
        Role role2 = RoleServices.getRoles().get(1);

        GrantAccess grantAccess1 = new GrantAccess(true,"",account2,role1);
        GrantAccess grantAccess2 = new GrantAccess(true, "", account1, role2);

        GrantAccessServices.insertGrantAccess(grantAccess1);
        GrantAccessServices.insertGrantAccess(grantAccess2);

        GrantAccessServices.getListGrantAccess().forEach(i -> System.out.println(i));
    }
}
