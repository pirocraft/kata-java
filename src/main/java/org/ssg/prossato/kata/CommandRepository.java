package org.ssg.prossato.kata;

import java.util.List;

public interface CommandRepository {
    void persist(Command command);

    List<Command> getAllCommands();
}
