package com.ds.algo.problem.solving.Arrays;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileHandling {

    public static void main(String[] args) {
        String path = "C:\\Users\\vineetsh\\Downloads\\bpmn\\vineet.bpmn";
        String original = readLineByLineJava8(path);
        // System.out.println(original);
        System.out.println("-----------------------------------------------");
        String duplicate = original.replaceAll("([^\\r]+\\r[^\\r])+", "");
        System.out.println(duplicate);
    }

    private static String readLineByLineJava8(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath)))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}
