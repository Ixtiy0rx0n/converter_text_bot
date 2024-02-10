package org.example.service;

import org.example.dto.UserDTO;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserDTO save(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        entity.setPhone(dto.getPhone());
        entity.setUsername(dto.getUsername());
        entity.setIsPremium(dto.getIsPremium());
        entity.setChatId(dto.getChatId());
        entity.setAddedTime(LocalDateTime.now());
        userRepository.save(entity);
        dto.setId(entity.getId());
        dto.setAddedTime(entity.getAddedTime());
        return dto;
    }

   /* public Boolean delete(UserDTO dto){
        Optional<UserEntity> optional = userRepository.findByChatId(dto.getChatId());
        UserEntity entity = optional.get();
        userRepository.delete(entity);
        return true;
    }*/

    public Boolean check(UserDTO dto){
        Optional<UserEntity> optional = userRepository.findByChatId(dto.getChatId());
        if (optional.isPresent()){
            return true;
        }
        else {
            return false;
        }
    }


}
