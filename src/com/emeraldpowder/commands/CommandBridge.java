package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.MachineState;
import com.emeraldpowder.MovingDirection;
import com.emeraldpowder.Position;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandBridge extends Command
{
    @Override
    public void execute(MachineState state)
    {
        state.bridgeNextStep = true;
    }
}
