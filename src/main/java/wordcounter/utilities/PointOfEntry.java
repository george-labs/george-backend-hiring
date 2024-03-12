package wordcounter.utilities;

import wordcounter.functionalities.InputOutputLogic;
import wordcounter.functionalities.impl.ConsoleIOLogicImpl;

public class PointOfEntry {
    private final InputOutputLogic inputOutputLogic;

    public PointOfEntry(){
        this.inputOutputLogic = new ConsoleIOLogicImpl();
        runIOLogic();
    }

    private void runIOLogic(){
        inputOutputLogic.completeIOLogic();
    }
}
