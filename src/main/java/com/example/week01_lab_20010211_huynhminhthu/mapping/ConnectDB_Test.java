package com.example.week01_lab_20010211_huynhminhthu.mapping;

import com.example.week01_lab_20010211_huynhminhthu.db.ConnectDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ConnectDB_Test {
    public static void main(String[] args) {
        try {
            ConnectDB dbConnect = ConnectDB.getInstance();
            EntityManager emf = dbConnect.getEmf().createEntityManager();

            EntityTransaction tr = emf.getTransaction();
            tr.begin();
            try {
                tr.commit();
            } catch (Exception e) {
                tr.rollback();
                System.out.println(e.getMessage());
            } finally {
                emf.close();
            }
            System.out.println("done");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
