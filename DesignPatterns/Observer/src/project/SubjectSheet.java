package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubjectSheet {

    private Map<String,Integer> sheet;

    public SubjectSheet(Group group){
        sheet = new HashMap<>();
        for (String student: group.getStudents()) {
            sheet.put(student, 0);
        }
    }

    public Map<String, Integer> getSheet() {
        return sheet;
    }
}
