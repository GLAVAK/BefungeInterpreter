package com.emeraldpowder;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class ConfigCommandRepository implements ICommandRepository
{
    private final IClassResolver classResolver;
    private Map<Character, String> classNames;

    private static final Logger logger = Logger.getLogger(ConfigCommandRepository.class);

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
            throw new ProgramException(String.format("Unknown symbol \"%s\"", symbol + ""));
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

            logger.debug("Command \"" + symbol + "\" instantiated");

            return command;
        }
        catch (Exception e)
        {
            throw new ConfigException("Error creating class specified in config", e);
        }
    }

    /**
     * Loads table of characters in program to commands binds
     *
     * @param tableLoader ITableLoader used to load table
     * @throws ConfigException If taleLoader fails
     */
    public void loadTable(ITableLoader tableLoader)
            throws ConfigException
    {
        classNames = tableLoader.loadTable();
    }
}
