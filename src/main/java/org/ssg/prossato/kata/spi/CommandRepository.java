package org.ssg.prossato.kata.spi;

import org.ssg.prossato.kata.Command;

import java.util.List;

public interface CommandRepository {
    void persist(Command command);

    List<Command> getAllCommands();
}
