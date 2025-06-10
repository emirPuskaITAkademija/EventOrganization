package com.itakademija.event.ejb.country;

import java.util.List;

public interface CountryServiceLocal {

    void create(Country country);

    Country find(Object id);

    List<Country> findAll();

    void edit(Country country);

    void remove(Country country);
}
