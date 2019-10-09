package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.PasswordManager;
import org.mickael.business.impl.AbstractManager;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Named;

@Named
public class PasswordManagerImpl extends AbstractManager implements PasswordManager {

    @Override
    public String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPassword = passwordEncoder.encode(password);

        return hashPassword;
    }

    @Override
    public boolean matches(String password, String hashPassword) {
        boolean matches = false;
        matches = BCrypt.checkpw(password, hashPassword);

        return matches;
    }
}
