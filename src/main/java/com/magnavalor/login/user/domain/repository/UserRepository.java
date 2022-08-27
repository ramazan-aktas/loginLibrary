package com.magnavalor.login.user.domain.repository;

import com.magnavalor.login.user.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // TODO jpl query ile custom bir query yazılacak
    // username and email geldiğinde bu ikisini paremetre alıp sadece user dönecek...


}
