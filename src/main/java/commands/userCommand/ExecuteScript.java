package commands.userCommand;

import commands.AbstractCommand;
import exception.CommandNeedArgumentException;
import exception.CommandNotAcceptArgumentsException;
import utility.FileManager;

/**
 * Команда, считывающая и выполняющая скрипт из файла
 */
public class ExecuteScript extends AbstractCommand {
    private FileManager fileManager = FileManager.getInstance();
    public ExecuteScript() {
        super("execute_script file_name - считать и исполнить скрипт из указанного файла.");
    }
    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) throw new CommandNeedArgumentException();
            fileManager.readScript(argument);
        } catch (CommandNotAcceptArgumentsException e) {
            System.out.println(e.toString());
        } finally {
            toHistory();
        }
    }
}
