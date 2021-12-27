package com.example.telegrambotbackend.telegrambot.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DefaultCommand implements BotCommand{
    @Override
    public String getCommandName() {
        return "default";
    }

    @Override
    public void executeCommand(String chatId, Message message, TelegramLongPollingBot bot) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Извини, " + message.getFrom().getFirstName() + "\n" +
                "Но такой команды не существует :( \n" +
                "Попробуй какую-нибудь из этих: \n" +
                "/start \n" +
                "/information \n" +
                "/services \n"
                );
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
