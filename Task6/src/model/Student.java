package model;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int studentId;
    private String name;
    private Group group;

    // конструктор с зависимостью
    public Student(int studentId, String name, Group group) {
        this.studentId = studentId;
        this.name = name;
        this.group = group;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;
        return studentId == student.studentId &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, group);
    }

    @Override
    public String toString() {
        return "Student{id=" + studentId +
                ", name='" + name + '\'' +
                ", group=" + group +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}
