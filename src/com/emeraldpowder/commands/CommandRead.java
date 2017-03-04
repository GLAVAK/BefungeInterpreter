package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.IMachineState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandRead extends Command
{
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void execute(IMachineState machineState)
    {
        String read = null;
        try
        {
            read = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        switch (character)
        {
            case '&':
                machineState.pushStack(Integer.parseInt(read));
                break;
            case '~':
                machineState.pushStack(read.charAt(0));
                break;
        }
    }
}
