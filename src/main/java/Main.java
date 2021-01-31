import commands.Book;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {
    public static TelegramBotsApi api;
    public static void main(String[] args) {
        ApiContextInitializer.init();
        api = new TelegramBotsApi();
        try {
            api.registerBot(new Bot());
            api.registerBot(new Book());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
