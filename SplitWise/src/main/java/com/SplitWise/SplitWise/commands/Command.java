package com.SplitWise.SplitWise.commands;

import com.SplitWise.SplitWise.Exceptions.UserNotFoundException;

public interface Command {

    public void execute(String input) throws UserNotFoundException;
    public  boolean matches(String input);

}
