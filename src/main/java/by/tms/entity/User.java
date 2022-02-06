package by.tms.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User {

    private int idUser;
    private int idUserRole;
    private String name;
    private String login;
    private String password;
    private String sessionID;
    private Timestamp userUpdateDate;

    public User(int idUserRole, String name, String login, String password, String sessionID, Timestamp userUpdateDate) {
        this.idUserRole = idUserRole;
        this.name = name;
        this.login = login;
        this.password = password;
        this.sessionID = sessionID;
        this.userUpdateDate = userUpdateDate;
    }

    public User(int idUser, int idUserRole, String name, String login, String password, String sessionID, Timestamp userUpdateDate) {
        this.idUser = idUser;
        this.idUserRole = idUserRole;
        this.name = name;
        this.login = login;
        this.password = password;
        this.sessionID = sessionID;
        this.userUpdateDate = userUpdateDate;
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.login = username;
        this.password = password;
    }

    public User(String name, String login, String password, String sessionId) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.sessionID = sessionId;
    }

    public User(String sessionId) {
        this.sessionID = sessionId;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(int idUserRole) {
        this.idUserRole = idUserRole;
    }

    public Timestamp getUserUpdateDate() {
        return userUpdateDate;
    }

    public void setUserUpdateDate(Timestamp userUpdateDate) {
        this.userUpdateDate = Timestamp.valueOf(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sessionID='" + sessionID + '\'' +
                '}';
    }
}

