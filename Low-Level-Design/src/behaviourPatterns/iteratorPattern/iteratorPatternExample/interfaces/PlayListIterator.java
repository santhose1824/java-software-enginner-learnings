package behaviourPatterns.iteratorPattern.iteratorPatternExample.interfaces;

import behaviourPatterns.iteratorPattern.iteratorPatternExample.services.Video;

public interface PlayListIterator {
    boolean hasNext();
    Video next();
}
