package ru.kpfu.itis.hyperbot.filemanager.Commands;

import ru.kpfu.itis.hyperbot.filemanager.RuntimeData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class LsInfoCommand extends Command{
    public LsInfoCommand() {
        name = "ls";
    }

    @Override
    public void execute(RuntimeData runtimeData, String params) {
        if (params.equals("info")) {
            Arrays.stream(new File(runtimeData.currentPath.toUri()).list()).
                    map(str -> {
                        return new File(str);
                    }).
                    sorted().
                    forEach((file) -> {
                        System.out.printf("%30s \t %20s %10s %10s %10s%n",
                                file.getName(),
                                new Date(file.lastModified()),
                                "R: " + file.canRead(),
                                "W: " + file.canWrite(),
                                file.length() + "kb");
                    });
        } else if (params.equals("")) {
            Arrays.stream(new File(runtimeData.currentPath.toUri()).list()).forEach(System.out::println);
        }
        else {
            System.out.println("wrong command params");
        }
    }
}
