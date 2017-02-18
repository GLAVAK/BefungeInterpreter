package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.MachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandAsk extends Command
{
    @Override
    public void execute(MachineState state)
    {
        String read = System.console().readLine();

        switch (character)
        {
            case '&': state.getStack().push(Integer.parseInt(read)); break;
            case '~': state.getStack().push((int) read.charAt(0)); break;
        }
    }
}
