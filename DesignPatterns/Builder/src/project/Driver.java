package project;

public class Driver {
    protected DriveCategory category;

    Driver(DriveCategory category) {
        this.category=category;
    }

    @Override
    public String toString() {
        return category.toString();
    }
}
