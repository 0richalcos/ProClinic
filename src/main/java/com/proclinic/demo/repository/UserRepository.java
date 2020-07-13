
package com.proclinic.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proclinic.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true, value = "select * from user where username=?1")
    User findUserByUserName(String username);

    @Query(nativeQuery = true, value = "select*from user_desc u,USER u1 WHERE u.user_id=u1.id AND u1.id=?1")
    User findUserByid(int id);

    @Query(nativeQuery = true, value = "select * from user where username=?1 and email=?2")
    User findUserByNameAndEmail(String username, String email);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update user set password=?1 where id=?2")
    int updateUserPassword(String password, int id);
}
