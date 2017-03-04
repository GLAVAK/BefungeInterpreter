package com.emeraldpowder;

import com.emeraldpowder.commands.CommandNoOp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by glavak on 28.02.17.
 */
public class ConfigCommandRepositoryTest
{
    private ConfigCommandRepository commandRepository;
    private MockClassResolver classResolver;

    @Before
    public void setUp() throws Exception
    {
        this.classResolver = new MockClassResolver();
        this.commandRepository = new ConfigCommandRepository(classResolver);

        commandRepository.loadTable(new MockTableLoader());
    }

    @Test
    public void getCommandForSymbol() throws Exception
    {
        classResolver.classToReturn = CommandNoOp.class;

        Command actual = commandRepository.getCommandForSymbol('@');

        Assert.assertTrue(actual instanceof CommandNoOp);
        Assert.assertEquals(1, classResolver.getClassCalledTimes);
        Assert.assertEquals("stop", classResolver.lastNameCalled);
    }
}

class MockClassResolver implements IClassResolver
{
    Class<?> classToReturn;
    String lastNameCalled;
    int getClassCalledTimes = 0;

    @Override
    public Class<?> getClassByName(String name) throws ClassNotFoundException
    {
        lastNameCalled = name;
        getClassCalledTimes++;
        return classToReturn;
    }
}

class MockTableLoader implements ITableLoader
{
    @Override
    public Map<Character, String> loadTable() throws IOException
    {
        Map<Character, String> result = new HashMap<>();

        result.put('@', "stop");
        result.put('v', "arrowDown");
        result.put('p', "p");

        return result;
    }
}