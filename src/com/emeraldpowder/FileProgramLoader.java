package com.emeraldpowder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by glavak on 28.02.17.
 */
public class FileProgramLoader implements IProgramLoader
{
    private final String filename;

    public FileProgramLoader(String filename)
    {
        this.filename = filename;
    }

    @Override
    public List<String> loadProgram() throws IOException
    {
        List<String> result = new ArrayList<>();

        BufferedReader programReader = new BufferedReader(new FileReader(filename));

        String line = programReader.readLine();
        int maxLineLength = 0;
        while (line != null)
        {
            result .add(line);
            maxLineLength = Math.max(maxLineLength, line.length());

            line = programReader.readLine();
        }

        // Set length of all lines equals to maximum:
        for (int i = 0; i < result.size(); i++)
        {
            while (result.get(i).length() < maxLineLength)
            {
                result.set(i, result.get(i) + " ");
            }
        }

        return result;
    }
}
