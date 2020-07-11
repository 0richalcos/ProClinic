
package com.proclinic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proclinic.demo.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true, value = "select * from user where username=?1")
    User findUserByUserName(String username);
    
    @Query(nativeQuery = true,value="select*from user_desc u,USER u1 WHERE u.user_id=u1.id AND u1.id=?1")
    User findUserByid(int id);
}



