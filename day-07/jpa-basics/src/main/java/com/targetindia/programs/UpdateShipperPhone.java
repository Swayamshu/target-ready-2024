package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JPAUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UpdateShipperPhone {
    static Shipper getShipperByID(int id) {
        Shipper shipper = null;
        try(EntityManager em = JPAUtil.createEntityManager()) {
            shipper = em.find(Shipper.class, id);
        }
        return shipper;
    }

    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter ID of shipper to be updated: ");
        Shipper shipper = getShipperByID(id);

        if(shipper == null) {
            System.out.printf("No shipper with given ID: %d found!", id);
            return;
        }

        String newPhone = KeyboardUtil.getString("Enter new phone: ");
        shipper.setPhone(newPhone);

        try (EntityManager em = JPAUtil.createEntityManager()) {
            var tx = em.getTransaction();

            try {
                tx.begin();
                em.merge(shipper);
                tx.commit();
                System.out.println("Successfully updated phone of shipper with ID: " + id);
            } catch (Exception e) {
                tx.rollback();
                log.warn("Error updating phone of shipper", e);
            }
        }
    }
}
