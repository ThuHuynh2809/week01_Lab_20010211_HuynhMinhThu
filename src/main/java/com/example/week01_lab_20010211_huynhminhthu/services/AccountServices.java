package com.example.week01_lab_20010211_huynhminhthu.services;

import com.example.week01_lab_20010211_huynhminhthu.models.Account;
import com.example.week01_lab_20010211_huynhminhthu.models.GrantAccess;
import com.example.week01_lab_20010211_huynhminhthu.models.Role;
import com.example.week01_lab_20010211_huynhminhthu.repositories.AccountRepository;
import com.example.week01_lab_20010211_huynhminhthu.repositories.GrantAccessRepository;
import com.example.week01_lab_20010211_huynhminhthu.repositories.RoleRepository;

import java.util.List;

public class AccountServices {
    private static AccountRepository accountDao = new AccountRepository();

    public static void insertAccount(Account account) {
        accountDao.insertAccount(account);
        RoleRepository roleDao = new RoleRepository();
        Role role = new Role("user", "user role", "", (byte) 1);
        roleDao.insertRole(role);

        GrantAccessRepository grantAccessDao = new GrantAccessRepository();
        GrantAccess grantAccess = new GrantAccess(true, "", account, role);
        grantAccessDao.insertGrantAccess(grantAccess);
    }

    public static Account searchAccount(String id) {
        return accountDao.searchAccount(id);
    }

    public static void dellAccount(String id) {
        accountDao.dellAccount(id);
        GrantAccessRepository grantAccessDao = new GrantAccessRepository();
        grantAccessDao.delete(id);
    }

    public static List<Account> getAccounts() {
        return accountDao.getAccounts();
    }
}