package com.github.raystorm.sample.session;

import java.io.Serializable;
import javax.p
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  Simple POJO User
 */
@Entity
public class SampleUser implements Serializable
{
    @Id
    private String userName;

    //TODO: byte[] w/ fancy erasure and scramble logic, HASH this value
    private transient String pass;

    private String name;

    private String email;

    public SampleUser() { }

    public SampleUser(String userName, String pass)
    {
       this.userName = userName;
       this.pass = pass;
    }

    public SampleUser(String userName, String pass, String name, String email)
    {
       this.userName = userName;
       this.pass = pass;
       this.name = name;
       this.email = email;
    }

    public void setPass(String pass) { this.pass = pass; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
