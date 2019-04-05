package ru.kpfu.itis.hyperbot.filemanager.Commands;

import ru.kpfu.itis.hyperbot.filemanager.RuntimeData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MkFileCommand extends Command {
    public MkFileCommand() {
        name = "mkfile";
    }
    @Override
    public void execute(RuntimeData runtimeData, String params) {
        if(params.isEmpty()) {
            System.out.println("enter filename");
        }
        else if(Files.exists(runtimeData.currentPath.resolve(params))) {
            System.out.println("file already exists");
        }
        else {
            File file = new File(runtimeData.currentPath.resolve(params).toUri());
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("can't create new file");
            }
        }
    }
}
