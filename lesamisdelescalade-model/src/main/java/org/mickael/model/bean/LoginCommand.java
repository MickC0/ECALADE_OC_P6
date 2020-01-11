package org.mickael.model.bean;

public class LoginCommand {

    private String email;
    private String password;

    public LoginCommand() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginCommand{" +
                       "email='" + email + '\'' +
                       ", password='" + password + '\'' +
                       '}';
    }
}