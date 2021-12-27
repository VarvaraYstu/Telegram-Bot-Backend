package com.example.telegrambotbackend.telegrambot.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HelloCommand implements BotCommand {

    @Override
    public String getCommandName() {
        return "привет";
    }

    @Override
    public void executeCommand(String chatId, Message message, TelegramLongPollingBot bot){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Привет, " + message.getFrom().getFirstName());
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
