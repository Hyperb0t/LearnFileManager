package ru.kpfu.itis.hyperbot.filemanager.Commands;

import ru.kpfu.itis.hyperbot.filemanager.RuntimeData;

import java.io.File;

public class MkDirCommand extends Command {
    public MkDirCommand() {
        name = "mkdir";
    }

    @Override
    public void execute(RuntimeData runtimeData, String params) {
        if(!params.isEmpty()) {
            new File(runtimeData.currentPath.resolve(params).toUri()).mkdirs();
        }
        else {
            System.out.println("enter directory name");
        }
    }
}
