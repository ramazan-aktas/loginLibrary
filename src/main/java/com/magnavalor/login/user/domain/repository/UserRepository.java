package com.magnavalor.login.user.domain.repository;

import com.magnavalor.login.user.domain.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT * FROM USERS WHERE USER_NAME = ? AND EMAIL = ?", nativeQuery = true)
    User findByEmailAndUserName(String userName, String emailAddress);
}
