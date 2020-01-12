package SOLID_Ex.logger.appenders.interfaces;

public interface File {

    void write();

    int getSize();

    void appendSb(String text);
}
