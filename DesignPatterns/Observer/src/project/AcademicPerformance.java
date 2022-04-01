package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AcademicPerformance implements IObservable{
    private ArrayList<Group> groups;
    private Map<Group,SubjectSheet> sheetMap;
    private LocalDate dateLastFilling;

    ArrayList<IObserver> observers;

    AcademicPerformance(ArrayList<Group> groups){
        observers = new ArrayList<>();

        this.groups = groups;
        sheetMap = new HashMap<>();
        for (Group group: groups) {
            sheetMap.put(group, new SubjectSheet(group));
        }
        dateLastFilling = LocalDate.now();
    }

    public void fillSheet(Map<Group,SubjectSheet> grades){
        for(Group group: grades.keySet()) {
            sheetMap.put(group,grades.get(group));
        }
        notifyObservers();
        dateLastFilling = LocalDate.now();
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public Map<Group, SubjectSheet> getSheetMap() {
        return sheetMap;
    }


    @Override
    public void addObserver(IObserver iObserver) {
        observers.add(iObserver);
    }

    @Override
    public void removeObserver(IObserver iObserver){
        observers.remove(iObserver);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer: observers) {
            observer.update(dateLastFilling);
        }
    }
}
