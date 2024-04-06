package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JPAUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GetOneShipper {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter shipper id to search: ");

        try (EntityManager em = JPAUtil.createEntityManager()) {
            var shipper = em.find(Shipper.class, id);

            if (shipper==null) {
                System.out.println("No shipper id found for id: " + id);
            } else {
                System.out.printf("Company Name: %s\n", shipper.getCompanyName());
                System.out.printf("Phone Number: %s\n", shipper.getPhone());
            }
        }
    }
}
