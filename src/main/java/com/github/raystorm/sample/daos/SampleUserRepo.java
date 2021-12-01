package com.github.raystorm.sample.daos;

import com.github.raystorm.sample.session.SampleUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SampleUserRepo extends CrudRepository<SampleUser, String>
{
    @Query("SELECT CASE WHEN EXISTS (\n" +
            " SELECT 1 FROM SampleUser " +
            "  WHERE userName = :userName and pass = :pass \n" +
            ")\n" +
            "THEN TRUE ELSE FALSE END FROM dual")
    public boolean isUser(@Param("userName") String userName,
                          @Param("pass") String pass);

    public SampleUser findByUserNameAndAndPass(String UserName, String pass);
}
