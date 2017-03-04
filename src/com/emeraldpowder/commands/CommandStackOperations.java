package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.IMachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandStackOperations extends Command
{
    @Override
    public void execute(IMachineState machineState)
    {
        switch (character)
        {
            case ':':
                int value = machineState.popStack();
                machineState.pushStack(value);
                machineState.pushStack(value);
                break;
            case '\\':
                int value1 = machineState.popStack();
                int value2 = machineState.popStack();
                machineState.pushStack(value1);
                machineState.pushStack(value2);
                break;
            case '$':
                machineState.popStack();
                break;
        }
    }
}
