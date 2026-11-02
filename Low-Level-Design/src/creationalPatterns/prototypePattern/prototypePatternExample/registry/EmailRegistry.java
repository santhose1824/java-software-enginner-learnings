package creationalPatterns.prototypePattern.prototypePatternExample.registry;

import creationalPatterns.prototypePattern.prototypePatternExample.concreteClasses.WelcomeEmail;
import creationalPatterns.prototypePattern.prototypePatternExample.interfaces.EmailTemplates;

import java.util.HashMap;
import java.util.Map;

public class EmailRegistry {
    private static final Map<String, EmailTemplates> emailTemplates = new HashMap<>();

    static {
        emailTemplates.put("welcome", new WelcomeEmail());
    }

    public static EmailTemplates getEmailTemplate(String type) {
        EmailTemplates prototype = emailTemplates.get(type);
        if (prototype == null) {
            throw new IllegalArgumentException("Unknown template: " + type);
        }
        return prototype.clone();
    }
}