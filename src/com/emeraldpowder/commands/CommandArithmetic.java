package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.Machine;
import com.emeraldpowder.MachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandArithmetic extends Command
{
    @Override
    public void execute(Machine machine)
    {
        int a = machine.state.popStack();
        int b = machine.state.popStack();
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

        machine.state.pushStack(result);
    }
}
