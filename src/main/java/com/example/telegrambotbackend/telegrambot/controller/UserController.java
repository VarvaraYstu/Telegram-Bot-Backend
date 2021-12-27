package com.example.telegrambotbackend.telegrambot.controller;

import com.example.telegrambotbackend.telegrambot.model.AddUserRequest;
import com.example.telegrambotbackend.telegrambot.model.AddUserResponse;
import com.example.telegrambotbackend.telegrambot.model.UserModel;
import com.example.telegrambotbackend.telegrambot.services.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PatchMapping("/api/subscribers_")
    public ResponseEntity<AddUserResponse> saveUser(@RequestBody AddUserRequest request){
        return ResponseEntity.ok(new AddUserResponse(userService.saveUser(
                new UserModel(
                        request.getFName(),
                        request.getLName(),
                        request.getSubscriptionType(),
                        request.getPrice()
                )
        )));
    }
}
