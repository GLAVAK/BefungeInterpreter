package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.MachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandPrint extends Command
{
    @Override
    public void execute(MachineState state)
    {
        String result = "";
        switch (character)
        {
            case ',':
                result = (char) state.getStack().pop().intValue() + "";
                break;
            case '.':
                result = state.getStack().pop() + " ";
                break;
        }
        System.out.print(result);
    }
}
