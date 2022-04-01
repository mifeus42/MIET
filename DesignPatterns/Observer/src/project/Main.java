package project;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Group> groups = new ArrayList<>();
        groups.add(new Group(1));
        groups.add(new Group(2));

        AcademicPerformance academicPerformance = new AcademicPerformance(groups);
        Professor mathProfessor = new Professor(academicPerformance);
        Deanery deanery = new Deanery(academicPerformance);
        Cathedra cathedra = new Cathedra(deanery);

        mathProfessor.fillSheet();

        for (Group group: academicPerformance.getGroups()) {
            System.out.println(group);
            System.out.println(academicPerformance.getSheetMap().get(group).getSheet());
        }
    }
}
