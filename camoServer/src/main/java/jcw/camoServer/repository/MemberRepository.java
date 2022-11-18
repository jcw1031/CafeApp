package jcw.camoServer.repository;

import jcw.camoServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
