package com.emeraldpowder;

/**
 * Created by glavak on 28.02.17.
 */
public interface ICommandRepository
{
    /**
     * Instantiates new Command, according to given symbol, as specified in config file
     *
     * @param symbol
     * @return
     * @throws ConfigException
     * @throws ProgramException if symbol has no associated command
     */
    Command getCommandForSymbol(char symbol)
            throws ConfigException, ProgramException;

}
