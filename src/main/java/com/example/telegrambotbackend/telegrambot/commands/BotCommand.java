package com.example.telegrambotbackend.telegrambot.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface BotCommand {
    String getCommandName();
    void executeCommand(String chatId, Message message, TelegramLongPollingBot bot);
}
