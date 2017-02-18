package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.Machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandRead extends Command
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void execute(Machine machine)
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
                machine.state.pushStack(Integer.parseInt(read));
                break;
            case '~':
                machine.state.pushStack(read.charAt(0));
                break;
        }
    }
}
