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
        switch (character)
        {
            case '+':
                state.getStack().push(state.getStack().pop() + state.getStack().pop());
                break;
            case '-':
                state.getStack().push(state.getStack().pop() - state.getStack().pop());
                break;
            case '*':
                state.getStack().push(state.getStack().pop() * state.getStack().pop());
                break;
            case '/':
                state.getStack().push(state.getStack().pop() / state.getStack().pop());
                break;
            case '%':
                state.getStack().push(state.getStack().pop() % state.getStack().pop());
                break;
        }
    }
}
