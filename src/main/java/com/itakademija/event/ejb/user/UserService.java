package com.itakademija.event.ejb.user;

import com.itakademija.event.orm.UserEntity;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

@Stateless
public class UserService implements UserServiceLocal {

    @Inject
    private Pbkdf2PasswordHash pbkdf2PasswordHash;

    @Override
    public UserEntity findByUsername(String username) {
        // query po username AND password
        // ili samo query by username
        // SELECT * FROM user WHERE user.username=? AND password=?
        UserEntity user =  new UserEntity();
        user.setUsername(username);
        String plainPassword = "!Dzenita123";
        String hashedPassword = pbkdf2PasswordHash.generate(plainPassword.toCharArray());
        user.setPassword(hashedPassword);
        return user;
    }

    @Override
    public boolean login(String username, String plainPassword) {
        UserEntity user = findByUsername(username);
        if (user == null) {
            return false;
        }
        String hashedPassword = user.getPassword();
        if (!pbkdf2PasswordHash.verify(plainPassword.toCharArray(), hashedPassword)) {
            return false;
        }
        return true;
    }
}
