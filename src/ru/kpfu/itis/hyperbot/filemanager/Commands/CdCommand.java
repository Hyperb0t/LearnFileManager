package ru.kpfu.itis.hyperbot.filemanager.Commands;

import ru.kpfu.itis.hyperbot.filemanager.RuntimeData;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CdCommand extends Command{
    public CdCommand() {
        name = "cd";
    }

    @Override
    public void execute(RuntimeData runtimeData, String params) {
        if(Files.exists(runtimeData.currentPath.resolve(params))) {
            runtimeData.currentPath = runtimeData.currentPath.resolve(Paths.get(params)).normalize();
        }
        else {
            System.out.println("path doesn't exist");
        }
    }
}
