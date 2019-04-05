package ru.kpfu.itis.hyperbot.filemanager.Commands;

import ru.kpfu.itis.hyperbot.filemanager.RuntimeData;

import java.io.File;
import java.nio.file.Files;

public class RmCommand extends Command {
    public RmCommand() {
        name = "rm";
    }

    @Override
    public void execute(RuntimeData runtimeData, String params) {
        try {
            String filename = params;
            if(Files.exists(runtimeData.currentPath.resolve(filename))) {
                File file = new File(runtimeData.currentPath.resolve(filename).toUri());
                file.delete();
            }
            else {
                System.out.println("file or directory not found");
            }
        }
        catch (SecurityException ex) {
            System.out.println("can't delete file or directory");
        }
    }
}
