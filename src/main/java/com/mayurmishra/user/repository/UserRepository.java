package com.mayurmishra.user.repository;

import com.mayurmishra.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project - user-service
 * Created By MAYUR on 01/08/22
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
