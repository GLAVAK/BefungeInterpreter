package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.MachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandToggleStringMode extends Command
{
    @Override
    public void execute(MachineState state)
    {
        state.isInStringMode = !state.isInStringMode;
    }
}
