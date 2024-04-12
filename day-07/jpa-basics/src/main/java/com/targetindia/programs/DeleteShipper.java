package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JPAUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class DeleteShipper {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter shipper Id to be deleted: ");

        try(EntityManager em = JPAUtil.createEntityManager()) {
            // managed shipper object
            Shipper shipper = em.find(Shipper.class, id);

            if(shipper == null) {
                System.out.printf("No shipper of given ID %d found!", id);
                return;
            }

            System.out.println("Shipper: " + shipper);
            String choice = KeyboardUtil.getString("Are you sure you want to delete this shipper? (yes/no) [no]: ");

            // delete can be performed only if the object is managed and not detached
            if(choice.equalsIgnoreCase("yes")) {
                em.remove(shipper);
                em.getTransaction().begin();
                em.getTransaction().commit();
                System.out.println("Successfully deleted: " + shipper);
            }
        }
    }
}
