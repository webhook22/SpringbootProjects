package com.mss.crudoperationdemo.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component

public class UserDetailsDTO implements Serializable {

    private static final long serialVersionUID = -5755566421440629128L;

    private Integer userID;
    private String name;
    private String email;
    private String department;

    public UserDetailsDTO(Integer userID, String name, String email, String department) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public UserDetailsDTO() {
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "UserDetailsDTO{" +
                "empID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetailsDTO)) return false;
        UserDetailsDTO that = (UserDetailsDTO) o;
        return userID.equals(that.userID) &&
                name.equals(that.name) &&
                email.equals(that.email) &&
                department.equals(that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, name, email, department);
    }
}
