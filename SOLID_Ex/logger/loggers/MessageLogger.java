package SOLID_Ex.logger.loggers;

import SOLID_Ex.logger.Enum.ErrorTypes;
import SOLID_Ex.logger.appenders.interfaces.Appender;
import SOLID_Ex.logger.loggers.interfaceML.Logger;

import java.io.IOException;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... args) {
        this.appenders = args;
    }

    @Override
    public void logInfo(String date, String message) throws IOException {
        logMessage(date, message, ErrorTypes.INFO);
    }

    @Override
    public void logWarning(String date, String message) throws IOException {
        logMessage(date, message, ErrorTypes.WARNING);
    }

    @Override
    public void logError(String date, String message) throws IOException {
        logMessage(date, message, ErrorTypes.ERROR);
    }

    @Override
    public void logCritical(String date, String message) throws IOException {
        logMessage(date, message, ErrorTypes.CRITICAL);
    }

    @Override
    public void logFatal(String date, String message) throws IOException {
        logMessage(date, message, ErrorTypes.FATAL);
    }


    private void logMessage(String date, String message, ErrorTypes errorType) throws IOException {
        for (Appender appender : this.appenders) {
            appender.append(date, errorType, message);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Logger info");
        stringBuilder.append(System.lineSeparator());
        for (Appender appender : this.appenders) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append(appender.toString());
        }
        return stringBuilder.toString();
    }
}
