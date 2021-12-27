package com.example.telegrambotbackend.telegrambot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddUserRequest {
    private String fName;
    private String lName;
    private int subscriptionType;
    private int price;

    public String getFName() {
        return fName;
    }
    public String getLName() {
        return lName;
    }
    public int getSubscriptionType() {
        return subscriptionType;
    }
    public int getPrice() {
        return price;
    }
}
