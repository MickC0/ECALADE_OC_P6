package org.mickael.business.contract.manager;

public interface PasswordManager {

    String hashPassword(String password);
    boolean matches(String password, String hashPassword);
}
