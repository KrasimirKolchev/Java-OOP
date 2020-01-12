package SOLID_Ex.logger.appenders;

import SOLID_Ex.logger.Enum.ErrorTypes;
import SOLID_Ex.logger.layouts.interfaceL.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ErrorTypes errType) {
        super(layout, errType);
    }

    @Override
    public void append(String date, ErrorTypes errType, String message) {
        if (this.canAppend(errType)) {
            System.out.println(this.format(date, errType, message));
            incrementNumberOfMessages();
        }
    }

}
