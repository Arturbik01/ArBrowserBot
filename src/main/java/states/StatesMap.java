package states;

import com.sun.tools.javac.Main;

import java.util.HashMap;
import java.util.Map;

public class StatesMap extends HashMap<Long, MainState>{
   private static StatesMap statesMap;

   public static StatesMap getInstance(){
       if (statesMap == null){
           statesMap = new StatesMap();
       }
       return statesMap;
   }


}
