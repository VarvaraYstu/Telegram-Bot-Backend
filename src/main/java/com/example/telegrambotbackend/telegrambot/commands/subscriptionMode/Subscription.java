package com.example.telegrambotbackend.telegrambot.commands.subscriptionMode;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Subscription {
    public Long id;
    public String fName;
    public String lName;
    public int subscriptionType;

    public String getCommandName() {
        return "ОФОРМИТЬ АБОНЕМЕНТ";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setSubscriptionType(int subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public void fNameCommand(String chatId, Message message, TelegramLongPollingBot bot) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Введите ваше имя: ");
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void lNameCommand(String chatId, Message message, TelegramLongPollingBot bot){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Введите вашу фамилию: ");
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void typeCommand(String chatId, Message message, TelegramLongPollingBot bot){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Введите цифру, соответствующую типу выбранного вами абонемента: \n" +
                            "1. Тренажерный зал + бассейн -2200р\n" +
                            "2. Спа - 2000р\n" +
                            "3. Комбо (тренажерный зал, спа, бассейн) - 4000р");
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void correctType(String chatId, Message message, TelegramLongPollingBot bot){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Пожалуйста, введите корректную цифру. (от 1 до 3)");
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void correctData(String chatId, Message message, TelegramLongPollingBot bot){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Пожалуйста, проверьте правильность введённых данных:\n" +
                "Имя: " + fName + "\n" + "Фамилия: " + lName + "\n" + "Выбранный тип абонемента: " + subscriptionType
                + "\n" + "Если всё верно ответьте ДА, если не верно - НЕТ."
                );
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void success(String chatId, Message message, TelegramLongPollingBot bot){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Ваши данные записаны, спасибо!");
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
