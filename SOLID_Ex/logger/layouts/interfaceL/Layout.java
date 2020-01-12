package SOLID_Ex.logger.layouts.interfaceL;

import SOLID_Ex.logger.Enum.ErrorTypes;

public interface Layout {

    String layoutFormat(String date, ErrorTypes errType, String message);
}
