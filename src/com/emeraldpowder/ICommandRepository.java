package com.emeraldpowder;

/**
 * Created by glavak on 28.02.17.
 */
public interface ICommandRepository
{
    /**
     * Creates new Command, according to given symbol, as specified in config file
     *
     * @param symbol
     * @return New instance of command of required type
     * @throws ConfigException if specified class not exists or can't be instantiated
     * @throws ProgramException if symbol has no associated command
     */
    Command getCommandForSymbol(char symbol)
            throws ConfigException, ProgramException;

}
