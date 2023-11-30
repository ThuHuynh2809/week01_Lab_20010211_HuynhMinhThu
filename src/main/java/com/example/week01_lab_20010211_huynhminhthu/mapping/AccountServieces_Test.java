package com.example.week01_lab_20010211_huynhminhthu.mapping;


import com.example.week01_lab_20010211_huynhminhthu.models.Account;
import com.example.week01_lab_20010211_huynhminhthu.services.AccountServices;

public class AccountServieces_Test {
    public static void main(String[] args) {
        Account account1 = new Account("Phong", "Sieu Nhan Cuong Phong", "123", "phong@gmail.com", "0988775443",  (byte) 1 );
        Account account2 = new Account("Lan", "Chim Xa Ca Lan", "123", "lan@gmail.com", "0123654789", (byte) 1);

        AccountServices.insertAccount(account1);
        AccountServices.insertAccount(account2);

        AccountServices.getAccounts().forEach(i -> System.out.println(i));
    }
}
