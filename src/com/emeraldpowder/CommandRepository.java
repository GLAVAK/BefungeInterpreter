package com.emeraldpowder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandRepository
{
    private Map<Character, String> classNames;
    private Map<Character, Class<?>> classes;

    public CommandRepository()
            throws IOException
    {
        loadTable();
    }

    /**
     * Instantiates new Command, according to given symbol, as specified in config file
     * @param symbol
     * @return
     * @throws ConfigException
     * @throws ProgramException
     */
    public Command getCommandForSymbol(char symbol)
            throws ConfigException, ProgramException
    {
        Class<?> requiredClass = classes.get(symbol);

        if (requiredClass == null)
        {
            // We haven't loaded it yet
            try
            {
                requiredClass = Class.forName(classNames.get(symbol));
            }
            catch (ClassNotFoundException e)
            {
                throw new ConfigException("Class specified in config not found", e);
            }
            catch (NullPointerException e)
            {
                throw new ProgramException(String.format("Unknown symbol '%s'", symbol + ""));
            }
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

    public void loadTable()
            throws IOException
    {
        classNames = new HashMap<>();
        classes = new HashMap<>();

        BufferedReader commandsReader = new BufferedReader(new FileReader("commands.txt"));

        String line = commandsReader.readLine();
        while (line != null)
        {
            String[] splited = line.split("=");
            classNames.put(splited[0].charAt(0), splited[1]);

            line = commandsReader.readLine();
        }
    }
}
