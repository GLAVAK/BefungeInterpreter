package com.emeraldpowder;

import com.emeraldpowder.commands.CommandNoOp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by glavak on 28.02.17.
 */
public class MachineTest
{
    private Machine machine;
    private MockCommandRepository commandRepository;

    @Test
    public void testGetSetProgramSymbol() throws Exception
    {
        Assert.assertEquals('<', machine.getProgramSymbol(new Position(3,2)));

        machine.setProgramSymbol(new Position(3,2), '@');

        Assert.assertEquals('@', machine.getProgramSymbol(new Position(3,2)));
    }

    @Test
    public void testMoveOneStep() throws Exception
    {
        machine.moveOneStep();

        Assert.assertEquals(new Position(1, 0), machine.state.getCurrentPosition());

        machine.state.movingDirection = MovingDirection.Down;
        machine.moveOneStep();

        Assert.assertEquals(new Position(1, 1), machine.state.getCurrentPosition());
    }

    @Before
    public void setUp() throws Exception
    {
        this.commandRepository = new MockCommandRepository();
        this.machine = new Machine(commandRepository);

        machine.loadProgram(new MockProgramLoader());
    }

    @Test
    public void testStep() throws Exception
    {
        commandRepository.commandToReturn = new CommandNoOp();

        machine.step();

        Assert.assertEquals(new Position(1, 0), machine.state.getCurrentPosition());
        Assert.assertEquals('>', commandRepository.lastSymbolCalled);
        Assert.assertEquals(1, commandRepository.getCommandCalledTimes);

        machine.step();

        Assert.assertEquals(new Position(2, 0), machine.state.getCurrentPosition());
        Assert.assertEquals(' ', commandRepository.lastSymbolCalled);
        Assert.assertEquals(2, commandRepository.getCommandCalledTimes);
    }
}

class MockCommandRepository implements ICommandRepository
{
    Command commandToReturn;
    int getCommandCalledTimes = 0;
    char lastSymbolCalled;

    @Override
    public Command getCommandForSymbol(char symbol) throws ConfigException, ProgramException
    {
        lastSymbolCalled = symbol;
        getCommandCalledTimes++;
        return commandToReturn;
    }
}

class MockProgramLoader implements IProgramLoader
{
    @Override
    public List<String> loadProgram() throws IOException
    {
        List<String> result = new ArrayList<>();

        result.add(">  v");
        result.add("    ");
        result.add("^  <");

        return result;
    }
}