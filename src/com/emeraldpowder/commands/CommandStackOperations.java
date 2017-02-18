package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.MachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandStackOperations extends Command
{
    @Override
    public void execute(MachineState state)
    {
        switch (character)
        {
            case ':':
                int value = state.getStack().peek();
                state.getStack().push(value);
                break;
            case '\\':
                int value1 = state.getStack().pop();
                int value2 = state.getStack().pop();
                state.getStack().push(value1);
                state.getStack().push(value2);
                break;
            case '$':
                state.getStack().pop();
                break;
        }
    }
}
