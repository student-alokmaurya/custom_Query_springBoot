package com.example.user_project.Repository;

import com.example.user_project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u from User u Where u.name like %:name% AND u.city like %:city%")
    List<User> findUserNameAndCity(@Param("name") String name,
                                   @Param("city") String city);

    @Query("SELECT u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);

//    @Query("SELECT u from User u where u.phone =:phone")
//    User findByPhone(@Param("phone") String phone);

}
