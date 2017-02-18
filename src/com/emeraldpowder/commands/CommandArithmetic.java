package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.MachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandArithmetic extends Command
{
    @Override
    public void execute(MachineState state)
    {
        int a = state.getStack().pop();
        int b = state.getStack().pop();
        int result = 0;

        switch (character)
        {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            case '%':
                result = a % b;
                break;
        }

        state.getStack().push(result);
    }
}
