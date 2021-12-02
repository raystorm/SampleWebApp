package com.github.raystorm.sample.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SampleUserRepo extends CrudRepository<SampleUser, String>
{
    /**
     * Simple check to see if the userName and Password combo exists
     * @param user
     * @param pass
     * @return  boolean flag indicating if the combination exists in the db
     */
    public boolean existsByUserNameAndPass(String user, String pass);

    /**
     *  Gets a user from the DB if the userName and password combo exist
     *  @param UserName
     *  @param pass
     *  @return
     */
    public SampleUser findByUserNameAndPass(String UserName, String pass);
}
