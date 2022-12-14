package task.server.command.impl;

import task.server.command.Command;
import task.server.command.exception.CommandException;
import task.server.model.AuthType;
import task.server.service.ServiceFactory;

public class CreateCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        var arguments = request.split(" ");
        if (arguments.length != 3) throw new CommandException("CREATE invalid syntax");

        if (ServiceFactory.getInstance().getAuthService().getAuthType(caller) != AuthType.admin)
            return "Should be manager";

        ServiceFactory.getInstance().getCaseService().addCase(arguments[1], arguments[2]);
        return "Success";
    }
}
