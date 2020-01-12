package SOLID_Ex.logger.appenders.interfaces;

import SOLID_Ex.logger.Enum.ErrorTypes;

import java.io.IOException;

public interface Appender {

    void append(String date, ErrorTypes errType, String message) throws IOException;

    void setErrorTypes(ErrorTypes errType);

    ErrorTypes getErrTypes();
}
