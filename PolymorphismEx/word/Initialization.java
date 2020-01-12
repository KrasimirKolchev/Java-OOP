package PolymorphismEx.word;

public class Initialization {
    static CommandInterface buildCommandInterface(StringBuilder text) {

        CommandInterface command = new CommandImpl(text);
        command.init();
        return command;
    }
}
