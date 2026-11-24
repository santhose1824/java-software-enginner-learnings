package behaviourPatterns.memntoPattern.problem;

import java.util.ArrayList;
import java.util.List;

public class ResumeSnapshot {
    public String name;
    public String education;
    public String experience;
    public List<String> skills;

    public ResumeSnapshot(ResumeEditor editor){
        this.name = editor.name;
        this.education = editor.education;
        this.experience = editor.experience;
        this.skills = new ArrayList<>(this.skills);
    }
}

