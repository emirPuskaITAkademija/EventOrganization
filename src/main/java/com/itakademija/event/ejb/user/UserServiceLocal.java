package com.itakademija.event.ejb.user;

import com.itakademija.event.orm.UserEntity;
import jakarta.ejb.Stateless;


public interface UserServiceLocal {

    UserEntity findByUsername(String username);

    /**
     * Vraća:
     * <li>1. true - ispravan korisnički nalog</li>
     * <li>2. false - neispravna kombinacija lozinke i šifre</li>
     *
     * @param username
     * @param password
     * @return authenticated
     */
    boolean login(String username, String password);
}
