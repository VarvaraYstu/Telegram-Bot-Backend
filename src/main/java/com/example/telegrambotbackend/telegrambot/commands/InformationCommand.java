package com.example.telegrambotbackend.telegrambot.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class InformationCommand implements BotCommand{
    @Override
    public String getCommandName() {
        return "/information";
    }

    @Override
    public void executeCommand(String chatId, Message message, TelegramLongPollingBot bot) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Magnolia Fitness - самый престижный фитнесс центр во вселенной The Sims.\uD83E\uDD29\n" +
                "Наш центр оборудован тренажёрным залом, бассейном, залом для йоги и спа-зоной, выключающей в себя сауну, баню, джакузи, массажные столики и ещё много-много всего\uD83D\uDE0D\n" +
                "Мы расположены по адресу: Вилоу Крик, 14\n" +
                "Приходи скорее, мы тебя ждём \uD83E\uDD70");
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
