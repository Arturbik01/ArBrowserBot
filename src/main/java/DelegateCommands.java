import commands.Start;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import states.MainState;
import states.StatesMap;

public class DelegateCommands extends BotCommand {

    public void start(long chatId){

        StatesMap.getInstance().put(chatId, MainState.BOOK);
        new Start(chatId);
    }

    public void book() {
    }
}
