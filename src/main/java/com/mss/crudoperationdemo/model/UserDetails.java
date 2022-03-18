package com.mss.crudoperationdemo.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = " userDetails")
@Component
public class UserDetails implements Serializable {
    private static final long serialVersionUID = 9196582316733157931L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    @Column(name = "department")
    private String department;

    public UserDetails() {
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "empID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetails)) return false;
        UserDetails that = (UserDetails) o;
        return Objects.equals(userID, that.userID) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, name, email, department);
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

    public UserDetails(Integer userID, String name, String email, String department) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.department = department;
    }


}
