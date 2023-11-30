package com.example.week01_lab_20010211_huynhminhthu.mapping;


import com.example.week01_lab_20010211_huynhminhthu.models.Log;
import com.example.week01_lab_20010211_huynhminhthu.services.LogServices;

import java.sql.Timestamp;
import java.util.Date;

public class LogServices_Test {
    public static void main(String[] args) {
        Date date = new Date();

        Log log1 = new Log("lan", new Timestamp(date.getTime()), new Timestamp(date.getTime()), "oke");

        LogServices.insertLog(log1);
    }
}
