package com.example.telegrambotbackend.telegrambot.services;

import com.example.telegrambotbackend.telegrambot.Repository.UserRepository;
import com.example.telegrambotbackend.telegrambot.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Long saveUser(UserModel model) {
        UserModel userModel = userRepository.save(model);
        return userModel.getId();
    }
}
