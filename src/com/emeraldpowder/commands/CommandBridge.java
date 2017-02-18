package com.emeraldpowder.commands;

import com.emeraldpowder.*;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandBridge extends Command
{
    @Override
    public void execute(Machine machine)
    {
        machine.state.bridgeNextStep = true;
    }
}
