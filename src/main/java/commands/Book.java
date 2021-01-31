package commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Book extends TelegramLongPollingBot implements Runnable{
    private Update update;
    public Book(Update update) {
    this.update = update;
    }

    public Book() {
        System.out.println("book const");
    }


    @Override
    public void run() {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Введите название книги");
        sendMessage.setChatId(update.getMessage().getChatId());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("book");
    }

    @Override
    public String getBotUsername() {
        return "ArBrowserBot";
    }

    @Override
    public String getBotToken() {
        return "1368025140:AAFHjcs2_wTizep6PxOSof5wvEJ3NHSjPOc";
    }
}
