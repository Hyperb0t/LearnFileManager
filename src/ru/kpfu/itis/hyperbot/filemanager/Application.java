package ru.kpfu.itis.hyperbot.filemanager;

import ru.kpfu.itis.hyperbot.filemanager.Commands.Command;
import ru.kpfu.itis.hyperbot.filemanager.Commands.CommandNotFoundException;
import ru.kpfu.itis.hyperbot.filemanager.Commands.Commands;

import java.nio.file.Paths;
import java.util.Scanner;

public class Application {
    void run() {
        RuntimeData runtimeData = new RuntimeData();
        runtimeData.currentPath = Paths.get("").toAbsolutePath();
        Command command;
        while (true) {
            System.out.print(runtimeData.currentPath);
            System.out.print(" : ");
            Scanner sc = new Scanner(System.in);
            String[] input = sc.nextLine().split(" ");
            try {
                command = Commands.parseString(input[0]);
                command.execute(runtimeData, input.length > 1 ? input[1] : "");
            } catch (CommandNotFoundException ex) {
                System.out.println("unknown command");
            }
        }
    }
}
