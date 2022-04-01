package project;

import java.util.ArrayList;

public class Group {
    private ArrayList<String> students;

    public Group(int i){
        students = new ArrayList<>();
        if(i == 1) {
            students.add("Romashkin");
            students.add("Kartashev");
            students.add("Kondratev");
            students.add("Morozof");
        }
        else {
            students.add("Tulnikov");
            students.add("Limonov");
            students.add("Zagorulko");
        }
    }
    public Group(ArrayList<String> students){
        this.students = students;
    }

    public void addStudent(String student){
        students.add(student);
    }

    public ArrayList<String> getStudents() {
        return students;
    }
}
