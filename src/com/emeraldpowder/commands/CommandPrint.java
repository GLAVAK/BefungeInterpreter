package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.MachineState;
import com.emeraldpowder.Main;
import com.emeraldpowder.MovingDirection;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandPrint extends Command
{
    @Override
    public void execute(MachineState state)
    {
        switch (character)
        {
            case ',': System.out.print((char)state.getStack().pop().intValue()); break;
            case '.': System.out.print(state.getStack().pop()+" "); break;
        }
    }
}
