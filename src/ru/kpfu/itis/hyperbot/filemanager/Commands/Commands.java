package ru.kpfu.itis.hyperbot.filemanager.Commands;

import sun.reflect.Reflection;

import java.util.Arrays;
import java.util.List;

public class Commands {
    private static List<Command> commandList = Arrays.asList(
            new CdCommand(),
            new LsInfoCommand(),
            new MkDirCommand(),
            new RmCommand(),
            new MkFileCommand()
    );

    public static Command parseString(String s) throws CommandNotFoundException {
        for (Command command : commandList) {
            if (command.name.equals(s)) {
                return command;
            }
        }
        throw new CommandNotFoundException();
    }
}
