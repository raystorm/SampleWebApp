package com.github.raystorm.sample.daos;

import java.io.Serializable;
import java.util.Objects;
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
    private String pass;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (!(o instanceof SampleUser)) { return false; }

        SampleUser that = (SampleUser) o;
        return Objects.equals(userName, that.userName)
             && Objects.equals(name, that.name)
             && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() { return Objects.hash(userName, name, email); }
}
