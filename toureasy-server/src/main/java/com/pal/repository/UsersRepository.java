package com.pal.repository;

import com.pal.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users,Integer> {
    Optional<Users> findByEmailIdAndPassword(String emailId,String password);

    Optional<Users> findByEmailId(String emailId);
}
