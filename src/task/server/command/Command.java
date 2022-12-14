package task.server.command;

import task.server.command.exception.CommandException;

public interface Command {
    String execute(Object caller, String request) throws CommandException;
}
