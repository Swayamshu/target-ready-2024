package com.targetindia.miniproject.dao;

import com.targetindia.miniproject.model.Customer;
import com.targetindia.miniproject.utils.JPAUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class JPACustomerDao implements CustomerDao {
    @Override
    public Customer save(Customer customer) throws DaoException {
        try (var em = JPAUtil.createEntityManager();){
            var tx = em.getTransaction();
            try {
                tx.begin();
                em.persist(customer);
                tx.commit();
                return customer;
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getById(int id) throws DaoException {
        return null;
    }

    @Override
    public void update(int id, Customer customer) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {

    }

    @Override
    public List<Customer> getAll() throws DaoException {
        return null;
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
        return null;
    }

    @Override
    public Customer getByPhone(String phone) throws DaoException {
        return null;
    }

    @Override
    public List<Customer> getByCity(String city) throws DaoException {
        return null;
    }
}
