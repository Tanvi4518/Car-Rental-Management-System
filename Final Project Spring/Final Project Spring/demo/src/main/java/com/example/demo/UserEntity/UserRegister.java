package com.example.demo.UserEntity;

import javax.persistence.*;

@Entity
@Table(name="conn")
public class UserRegister {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="first_name", nullable=false)
    private String firstName;
    
    @Column(name="last_name", nullable=false)
    private String lastName;

    @Column(name="gender", nullable=false)
    private String gender;

    @Column(name="mobile_number", nullable=false,unique=true)
    private String mobileNumber;

    @Column(name="dob", nullable=false)
    private String dob;

    @Column(name="email", nullable=false, length=200)
    private String email;

    @Column(name="customer_pass", nullable=false,unique=true)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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
        return "UserRegister [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
                + ", mobileNumber=" + mobileNumber + ", dob=" + dob + ", email=" + email + ", password=" + password
                + "]";
    }

    
    
    



}
