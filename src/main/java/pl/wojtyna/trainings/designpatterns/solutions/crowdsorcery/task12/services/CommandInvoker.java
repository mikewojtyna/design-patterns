package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task12.services;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class CommandInvoker {

    private final Deque<Command> queue;

    public CommandInvoker() {
        queue = new ConcurrentLinkedDeque<>();
    }

    public void invoke(Command command) {
        command.execute();
        queue.add(command);
    }

    public void undo() {
        var command = queue.pollLast();
        if (command != null) {
            command.undo();
        }
    }

    public void undo(CommandId commandId) {
        queue.stream().filter(command -> command.id().equals(commandId)).findAny().ifPresent(Command::undo);
    }

    public void repeat(CommandId commandId) {
        queue.stream().filter(command -> command.id().equals(commandId)).findAny().ifPresent(Command::execute);
    }
}
