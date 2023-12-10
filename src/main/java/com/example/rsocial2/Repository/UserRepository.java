package com.example.rsocial2.Repository;

import com.example.rsocial2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Adicione métodos personalizados, se necessário
}