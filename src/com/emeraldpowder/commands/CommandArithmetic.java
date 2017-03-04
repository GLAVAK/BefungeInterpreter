package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.IMachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandArithmetic extends Command
{
    @Override
    public void execute(IMachineState machineState)
    {
        int a = machineState.popStack();
        int b = machineState.popStack();
        int result = 0;

        switch (character)
        {
            case '+':
                result = a + b;
                break;
            case '-':
                result = b - a;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = b / a;
                break;
            case '%':
                result = a % b;
                break;
        }

        machineState.pushStack(result);
    }
}
