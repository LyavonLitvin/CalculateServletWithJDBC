package by.tms.entity;

public class UserRole {
    private int idUserRole;
    private String userRole;

    public UserRole() {
    }

    public UserRole(int userRoleId, String userRole) {
        this.idUserRole = userRoleId;
        this.userRole = userRole;
    }

    public int getUserRoleId() {
        return idUserRole;
    }

    public void setUserRoleId(int idUserRole) {
        this.idUserRole = idUserRole;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
