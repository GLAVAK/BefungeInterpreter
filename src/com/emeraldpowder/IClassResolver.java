package com.emeraldpowder;

/**
 * Created by glavak on 28.02.17.
 */
public interface IClassResolver
{
    /**
     * Returns Class object by class name
     *
     * @param name
     * @return Class\<?\> object for current class
     * @throws ClassNotFoundException
     */
    Class<?> getClassByName(String name) throws ClassNotFoundException;
}
