package wordcounter.utilities;

import wordcounter.functionalities.FileIOLogicImpl;
import wordcounter.functionalities.InputOutputLogic;
import wordcounter.functionalities.impl.ConsoleIOLogicImpl;

import java.util.Objects;

public class PointOfEntry {
    private final InputOutputLogic inputOutputLogic;

    public PointOfEntry(String[] args){
        if(Objects.nonNull(args) && !args[0].isEmpty()){
            this.inputOutputLogic = new FileIOLogicImpl(args[0]);
        }else{
            this.inputOutputLogic = new ConsoleIOLogicImpl();
        }
        runIOLogic();
    }

    private void runIOLogic(){
        inputOutputLogic.completeIOLogic();
    }
}
