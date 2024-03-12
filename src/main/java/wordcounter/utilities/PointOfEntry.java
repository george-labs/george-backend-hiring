package wordcounter.utilities;

import wordcounter.functionalities.InputOutputLogic;
import wordcounter.functionalities.impl.ConsoleIOLogicImpl;

public class PointOfEntry {
    private InputOutputLogic inputOutputLogic;

    public PointOfEntry(String arg){
        if("console".equalsIgnoreCase(arg)){
            this.inputOutputLogic = new ConsoleIOLogicImpl();
        }
        runIOLogic();
    }

    private void runIOLogic(){
        inputOutputLogic.completeIOLogic();
    }
}
