package com.example.week01_lab_20010211_huynhminhthu.repositories;

import java.util.List;

import com.example.week01_lab_20010211_huynhminhthu.db.ConnectDB;
import com.example.week01_lab_20010211_huynhminhthu.models.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RoleRepository {
    private EntityManager em;

    public RoleRepository() {
        em = ConnectDB.getInstance().getEmf().createEntityManager();
    }

    public void insertRole(Role role) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(role);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public List<Role> getRoles() {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "select * from role";
            List<Role> rl = em.createNativeQuery(sql, Role.class).getResultList();

            tr.commit();
            return rl;
        } catch (Exception e) {
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}