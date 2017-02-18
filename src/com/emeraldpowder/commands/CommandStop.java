package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.Machine;
import com.emeraldpowder.MachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandStop extends Command
{
    @Override
    public void execute(Machine machine)
    {
        machine.state.Stop();
    }
}
