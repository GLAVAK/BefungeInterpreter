package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.MachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandLogical extends Command
{
    @Override
    public void execute(MachineState state)
    {
        switch (character)
        {
            case '!':
                int value = state.getStack().pop();
                state.getStack().push((value == 1) ? 0 : 1);
                break;
            case '`':
                boolean greater = state.getStack().pop() < state.getStack().pop();
                state.getStack().push(greater ? 1 : 0);
                break;
        }
    }
}
