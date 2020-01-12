package SOLID_Ex.logger.layouts;

import SOLID_Ex.logger.Enum.ErrorTypes;
import SOLID_Ex.logger.layouts.interfaceL.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String layoutFormat(String date, ErrorTypes errType, String message) {
        return String.format("%s - %s - %s", date, errType, message);
    }
}
