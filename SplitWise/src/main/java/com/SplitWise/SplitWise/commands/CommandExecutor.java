package com.SplitWise.SplitWise.commands;

import com.SplitWise.SplitWise.Exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void removeCommand(Command command){
        commandList.remove(command);
    }

    public void execute(String input) throws UserNotFoundException {
        for(Command command:commandList){
            if(command.matches(input)){
                command.execute(input);
            }
        }
    }
}
