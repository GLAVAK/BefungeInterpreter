package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.IMachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandPrint extends Command
{
    @Override
    public void execute(IMachineState machineState)
    {
        String result = "";
        switch (character)
        {
            case ',':
                result = machineState.popStackChar() + "";
                break;
            case '.':
                result = machineState.popStack() + " ";
                break;
        }
        machineState.getStdout().print(result);
    }
}
