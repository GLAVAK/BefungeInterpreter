package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.IMachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandAsk extends Command
{
    @Override
    public void execute(IMachineState machineState)
    {
        String read = System.console().readLine();
        int value = 0;

        switch (character)
        {
            case '&':
                value = Integer.parseInt(read);
                break;
            case '~':
                value = (int) read.charAt(0);
                break;
        }

        machineState.pushStack(value);
    }
}
