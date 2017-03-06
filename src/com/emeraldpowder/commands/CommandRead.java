package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.ConfigException;
import com.emeraldpowder.IMachineState;
import com.emeraldpowder.ProgramException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandRead extends Command
{
    private BufferedReader br;

    @Override
    public void execute(IMachineState machineState)
            throws ProgramException, ConfigException
    {
        String read;
        try
        {
            if (br == null)
            {
                br = new BufferedReader(new InputStreamReader(machineState.getStdin()));
            }
            read = br.readLine();
        }
        catch (IOException e)
        {
            throw new ConfigException("Error reading stdin");
        }

        try
        {
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
        catch (Exception e)
        {
            throw new ProgramException("Error parsing stdin");
        }
    }
}
