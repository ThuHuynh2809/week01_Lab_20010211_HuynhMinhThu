package com.example.week01_lab_20010211_huynhminhthu.repositories;

import java.util.List;

import com.example.week01_lab_20010211_huynhminhthu.db.ConnectDB;
import com.example.week01_lab_20010211_huynhminhthu.models.Log;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LogRepository {
    private EntityManager em;

    public LogRepository() {
        em = ConnectDB.getInstance().getEmf().createEntityManager();
    }

    public void insertLog(Log log) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(log);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public List<Log> getLogs() {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "select * from log";
            List<Log> rl = em.createNativeQuery(sql, Log.class).getResultList();

            tr.commit();
            return rl;
        } catch (Exception e) {
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}