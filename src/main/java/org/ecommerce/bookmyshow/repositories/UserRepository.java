package org.ecommerce.bookmyshow.repositories;

import org.ecommerce.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    public Optional<User> findById(Long userId);

    public Optional<User> findByEmail(String email);

}
