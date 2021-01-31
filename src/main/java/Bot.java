import commands.Book;
import commands.Help;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    private static Runnable commandRunner;
    private static Thread commandThread;
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        if (update.getMessage() == null || update.getMessage().getText().isEmpty()) throw new NullPointerException();
        if (update.getMessage().getText().startsWith("/")){
            String command = update.getMessage().getText();
            switch (command){
                case "/book":
                    commandRunner = new Book(update);
                    commandThread = new Thread(commandRunner);
                    commandThread.start();
                    break;
                default:
                    commandRunner = new Help();

            }
        }
    }



    @Override
    public String getBotUsername() {
        return "ArBrowserBot";
    }

    @Override
    public String getBotToken() {
        return "";
    }
}
