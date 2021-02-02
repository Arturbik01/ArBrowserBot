import config.LoadConfig;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import states.MainState;
import states.StatesMap;
import states.start.Start;

import java.io.IOException;

public class Bot extends TelegramLongPollingBot {
    private LoadConfig loadConfig;
    private static StatesMap map = StatesMap.getInstance();
    {
        try {
            loadConfig = new LoadConfig("src/main/resources/config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message inputMessage = update.getMessage();
        if (inputMessage.getText().equalsIgnoreCase("/start")){
            map.put(inputMessage.getChatId(), MainState.START);
            new Start(inputMessage.getChatId());
        }



    }



    @Override
    public String getBotUsername() {
       return loadConfig.getBotName("telegram.name");
    }

    @Override
    public String getBotToken() {
        return loadConfig.getToken("telegram.token");
    }
}
