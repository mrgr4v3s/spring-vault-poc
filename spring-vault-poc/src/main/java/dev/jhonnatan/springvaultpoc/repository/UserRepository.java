package dev.jhonnatan.springvaultpoc.repository;

import dev.jhonnatan.springvaultpoc.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
