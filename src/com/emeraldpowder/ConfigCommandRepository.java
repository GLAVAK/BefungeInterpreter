package com.emeraldpowder;

import java.io.IOException;
import java.util.Map;

/**
 * Created by glavak on Feb 17, 17.
 */
public class ConfigCommandRepository implements ICommandRepository
{
    private final IClassResolver classResolver;
    private Map<Character, String> classNames;

    public ConfigCommandRepository(IClassResolver classResolver)
    {
        this.classResolver = classResolver;
    }

    public Command getCommandForSymbol(char symbol)
            throws ConfigException, ProgramException
    {
        String className = classNames.get(symbol);
        if (className == null)
        {
            throw new ProgramException(String.format("Unknown symbol '%s'", symbol + ""));
        }

        Class<?> requiredClass;
        try
        {
            requiredClass = classResolver.getClassByName(className);
        }
        catch (ClassNotFoundException e)
        {
            throw new ConfigException("Class specified in config not found", e);
        }

        try
        {
            // Instantiate command
            Command command = (Command) requiredClass.newInstance();
            command.character = symbol;
            return command;
        }
        catch (Exception e)
        {
            throw new ConfigException("Error creating class specified in config", e);
        }
    }

    public void loadTable(ITableLoader tableLoader)
            throws ConfigException
    {
        classNames = tableLoader.loadTable();
    }
}
