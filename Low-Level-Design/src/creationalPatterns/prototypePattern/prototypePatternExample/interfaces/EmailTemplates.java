package creationalPatterns.prototypePattern.prototypePatternExample.interfaces;

public interface EmailTemplates extends Cloneable {
    EmailTemplates clone();
    void setContent(String content);
    void setSubject(String subject);
    void send(String to);
}