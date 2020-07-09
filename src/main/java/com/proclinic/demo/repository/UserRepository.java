
package com.proclinic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proclinic.demo.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true, value = "select * from user where username=?1")
    User findUserByUserName(String username);
}

