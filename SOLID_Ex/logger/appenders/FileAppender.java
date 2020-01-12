package SOLID_Ex.logger.appenders;

import SOLID_Ex.logger.Enum.ErrorTypes;
import SOLID_Ex.logger.appenders.interfaces.File;
import SOLID_Ex.logger.layouts.interfaceL.Layout;

public class FileAppender extends AppenderImpl {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    public FileAppender(Layout layout, ErrorTypes errType) {
        super(layout, errType);
    }

    private void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String date, ErrorTypes errType, String message) {
        if (this.file == null) {
            this.setFile(new LogFile());
        }

        if (this.canAppend(errType)) {
            String text = this.format(date, errType, message);
            this.file.appendSb(text);
            this.file.write();
            incrementNumberOfMessages();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
