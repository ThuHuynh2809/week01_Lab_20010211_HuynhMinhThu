package com.example.week01_lab_20010211_huynhminhthu.db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDB {
    private static ConnectDB instance;
    private EntityManagerFactory emf;

    private ConnectDB() {
        try {
            emf = Persistence.createEntityManagerFactory("mydb");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ConnectDB getInstance() {
        if (instance == null) {
            instance = new ConnectDB();
        }
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }


}