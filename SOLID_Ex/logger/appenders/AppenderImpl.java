package SOLID_Ex.logger.appenders;

import SOLID_Ex.logger.Enum.ErrorTypes;
import SOLID_Ex.logger.appenders.interfaces.Appender;
import SOLID_Ex.logger.layouts.interfaceL.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ErrorTypes errType;
    private int numberOfMessages;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.errType = ErrorTypes.INFO;
        this.numberOfMessages = 0;
    }

    protected AppenderImpl(Layout layout, ErrorTypes errType) {
        this(layout);
        this.setErrorTypes(errType);
    }

    @Override
    public ErrorTypes getErrTypes() {
        return this.errType;
    }

    protected String format(String date, ErrorTypes errType, String message) {
        return this.layout.layoutFormat(date, errType, message);
    }

    @Override
    public void setErrorTypes(ErrorTypes errType) {
        this.errType = errType;
    }

    protected boolean canAppend(ErrorTypes errorTypes) {
        return this.errType.ordinal() <= errorTypes.ordinal();
    }

    protected void incrementNumberOfMessages() {
        this.numberOfMessages++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d"
                , this.getClass().getSimpleName()
                , this.layout.getClass().getSimpleName()
                , this.errType.toString()
                , this.numberOfMessages
        );
    }
}
