package com.example.week01_lab_20010211_huynhminhthu.services;

import com.example.week01_lab_20010211_huynhminhthu.models.Log;
import com.example.week01_lab_20010211_huynhminhthu.repositories.LogRepository;

import java.util.List;

public class LogServices {
    private static LogRepository logDao = new LogRepository();

    public static void insertLog(Log log) {
        logDao.insertLog(log);
    }

    public static List<Log> getLogs() {
        return logDao.getLogs();
    }
}