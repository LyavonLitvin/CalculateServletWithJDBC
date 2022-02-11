package by.tms.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User {

    private int idUser;
    private int userRoleId;
    private String name;
    private String login;
    private String password;
    private String email;
    private String secretQuestion;
    private Timestamp userUpdateDate;
    private String sessionID;

    public User(int userRoleId, String name, String login, String password, String email, String secretQuestion, Timestamp userUpdateDate, String sessionID) {
        this.userRoleId = userRoleId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.secretQuestion = secretQuestion;
        this.userUpdateDate = userUpdateDate;
        this.sessionID = sessionID;
    }

    public User(int userRoleId, String name, String login, String password, String email, String secretQuestion, Timestamp userUpdateDate) {
        this.userRoleId = userRoleId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.secretQuestion = secretQuestion;
        this.userUpdateDate = userUpdateDate;
    }
    public User(int idUser, int userRoleId, String name, String login, String password, String email, String secretQuestion, Timestamp userUpdateDate) {
        this.idUser = idUser;
        this.userRoleId = userRoleId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.secretQuestion = secretQuestion;
        this.userUpdateDate = userUpdateDate;
    }
    public User(int idUser, int userRoleId, String name, String login, String password, String email, String secretQuestion, Timestamp userUpdateDate, String sessionID) {
        this.idUser = idUser;
        this.userRoleId = userRoleId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.secretQuestion = secretQuestion;
        this.userUpdateDate = userUpdateDate;
        this.sessionID = sessionID;
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

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Timestamp getUserUpdateDate() {
        return userUpdateDate;
    }

    public void setUserUpdateDate(Timestamp userUpdateDate) {
        this.userUpdateDate = Timestamp.valueOf(LocalDateTime.now());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
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

