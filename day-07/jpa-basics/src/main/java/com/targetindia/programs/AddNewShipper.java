package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JPAUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddNewShipper {
    public static void main(String[] args) {
        System.out.println("Enter new shipper data: ");
        int id = KeyboardUtil.getInt("ID            : ");
        String companyName = KeyboardUtil.getString("Company Name  : ");
        String phone = KeyboardUtil.getString("Phone         : ");
        Shipper newShipper = new Shipper(id, companyName, phone);

        try (EntityManager em = JPAUtil.createEntityManager()) {
            var tx = em.getTransaction();
            tx.begin();

            try {
                em.persist(newShipper);
                tx.commit(); // all DML statements execute here
                System.out.printf("New Shipper %s added", newShipper.toString());
            } catch (Exception e) {
                log.warn("Error adding new shipper data", e);
                tx.rollback();
            }
        } // em.close();
    }
}
