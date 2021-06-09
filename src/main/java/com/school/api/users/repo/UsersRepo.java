package com.school.api.users.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.api.users.model.User;

public interface UsersRepo extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
