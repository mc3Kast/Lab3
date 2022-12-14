package task.server.command.impl;

import task.server.command.Command;
import task.server.command.exception.CommandException;
import task.server.model.AuthType;
import task.server.service.ServiceFactory;

public class DisconnectCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        ServiceFactory.getInstance().getAuthService().setAuthType(caller, AuthType.guest);
        return "Disconnected";
    }
}
