package com.example.telegrambotbackend.telegrambot.services;

import com.example.telegrambotbackend.telegrambot.model.UserModel;

public interface UserService {
    Long saveUser(UserModel model);
}
