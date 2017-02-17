package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.MachineState;
import com.emeraldpowder.Main;
import com.emeraldpowder.MovingDirection;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandNoOp extends Command
{
    @Override
    public void execute(MachineState state)
    {
        // Do nothing
    }
}
