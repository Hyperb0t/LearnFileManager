package ru.kpfu.itis.hyperbot.filemanager.Commands;

import ru.kpfu.itis.hyperbot.filemanager.RuntimeData;

public abstract class Command {
    protected String name;
    public abstract void execute(RuntimeData runtimeData, String params);
}
