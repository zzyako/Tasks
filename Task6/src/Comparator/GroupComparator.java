package Comparator;

import model.Student;

import java.util.Comparator;

public class GroupComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        // по номеру курса, по названию группы
        int courseComparison = Integer.compare(s1.getGroup().getCourse(), s2.getGroup().getCourse());
        if (courseComparison != 0) {
            return courseComparison;
        }
        return s1.getGroup().getGroupName().compareTo(s2.getGroup().getGroupName());
    }
}
