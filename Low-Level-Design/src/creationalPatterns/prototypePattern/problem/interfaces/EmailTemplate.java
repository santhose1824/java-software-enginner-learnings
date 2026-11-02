package creationalPatterns.prototypePattern.problem.interfaces;

public interface EmailTemplate {
    void setContent();
    void send(String to);
}

