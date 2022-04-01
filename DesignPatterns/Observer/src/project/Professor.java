package project;

import java.util.Map;

public class Professor {
    public AcademicPerformance academicPerformance;

    Professor(AcademicPerformance academicPerformance){
        this.academicPerformance = academicPerformance;
    }

    public void fillSheet(){
        Map<Group,SubjectSheet> grades = academicPerformance.getSheetMap();
        for (Group group : academicPerformance.getGroups()){
            for(String student : group.getStudents()){
                academicPerformance.getSheetMap().get(group).getSheet().put(student, (int)(Math.random() * 5));
            }
        }
        academicPerformance.fillSheet(grades);
    }
}
