package org.example;

import org.example.controller.MyBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class ConverterTextBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConverterTextBotApplication.class, args);
//        try {
//            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//
//            telegramBotsApi.registerBot(new MyBot());
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }

    }

}
