package com.itakademija.event.ejb.country;

import com.itakademija.event.ejb.AbstractService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * EJB Enterprise Java Bean
 * <p>
 * To su Java KLase koje sadrže neku business logiku
 * </p>
 */
@Stateless
public class CountryService extends AbstractService<Country> implements CountryServiceLocal {

    @PersistenceContext(unitName = "eventPU")
    private EntityManager entityManager;

    public CountryService() {
        super(Country.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
