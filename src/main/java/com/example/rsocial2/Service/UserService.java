package com.example.rsocial2.Service;

import com.example.rsocial2.Model.User;
import com.example.rsocial2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(Long.valueOf(id));
        return userOptional.orElse(null);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User updatedUser) {
        if (userRepository.existsById(Long.valueOf(id))) {
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        }
        return null; // Usuário não encontrado para atualização
    }

    public User deleteUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(Long.valueOf(id));
        if (userOptional.isPresent()) {
            userRepository.deleteById(Long.valueOf(id));
            return userOptional.get();
        }
        return null; // Usuário não encontrado para exclusão
    }
}

