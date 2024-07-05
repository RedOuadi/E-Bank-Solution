package com.service;

import com.dto.UserDTO;
import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO saveUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        user = userRepository.save(user);
        return convertToDTO(user);
    }

    public List<UserDTO> getAllUsersDTO() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserDTOById(Long id) {
        return userRepository.findById(id)
                .map(this::convertToDTO);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .userId((long) user.getUserId())
                .nom(user.getNom())
                .email(user.getEmail())
                .motDePasse(user.getMotDePasse())
                .build();
    }

    private User convertToEntity(UserDTO userDTO) {
        return User.builder()
                .userId(Math.toIntExact(userDTO.getUserId()))
                .nom(userDTO.getNom())
                .email(userDTO.getEmail())
                .motDePasse(userDTO.getMotDePasse())
                .build();
    }
}



