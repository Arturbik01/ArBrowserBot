import commands.Start;
import config.LoadConfig;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import states.MainState;
import states.StatesMap;

public class Bot extends TelegramLongPollingBot {
    private LoadConfig loadConfig = new LoadConfig();
    private static StatesMap map = StatesMap.getInstance();
    private DelegateCommands commands = new DelegateCommands();

    {
        commands.setCommand("start");
        commands.setCommand("book");
    }
    @Override
    public void onUpdateReceived(Update update) {
        Message inputMessage = update.getMessage();

        long chatId = inputMessage.getChatId();
        if (inputMessage.getText().startsWith("/")){
            switch (inputMessage.getText()) {
                case "/start" -> commands.start(chatId);
                case "/book" -> commands.book();
            }
        }
    }



    @Override
    public String getBotUsername() {
       return loadConfig.getName();
    }

    @Override
    public String getBotToken() {
        return loadConfig.getToken();
    }
}
