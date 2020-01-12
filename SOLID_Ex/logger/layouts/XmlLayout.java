package SOLID_Ex.logger.layouts;

import SOLID_Ex.logger.Enum.ErrorTypes;

public class XmlLayout extends SimpleLayout {

    @Override
    public String layoutFormat(String date, ErrorTypes errType, String message) {
        return String.format("<log>%s\t<date>%s</date>%s\t<level>%s</level>%s\t<message>%s</message>%s</log>",
                System.lineSeparator(),
                date,
                System.lineSeparator(),
                errType.toString(),
                System.lineSeparator(),
                message,
                System.lineSeparator());
    }
}
