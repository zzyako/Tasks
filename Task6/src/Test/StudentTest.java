package Test;

import model.Group;
import model.Student;
import Comparator.GroupComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class StudentTest {

    @Test
    public void testEqualsAndHashCode() {
        Group group1 = new Group(101, "Mathematics", 1);
        Group group2 = new Group(101, "Mathematics", 1);

        Student student1 = new Student(1, "Ivan Ivanov", group1);
        Student student2 = new Student(1, "Ivan Ivanov", group2);

        Assert.assertEquals(student1, student2);

        Assert.assertEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    public void testNaturalOrderingByName() {
        Group group1 = new Group(101, "Physics", 2);
        Group group2 = new Group(102, "Chemistry", 1);
        Group group3 = new Group(103, "Biology", 3);

        Student student1 = new Student(3, "Anna Petrov", group1);
        Student student2 = new Student(2, "Boris Sidorov", group2);
        Student student3 = new Student(1, "Clara Ivanova", group3);

        List<Student> students = Arrays.asList(student1, student2, student3);
        Collections.sort(students);

        List<Student> expected = Arrays.asList(student1, student2, student3);
        Assert.assertEquals(expected, students);
    }

    @Test

    public void testOrderingByGroup() {
        Group group1 = new Group(101, "Physics", 2);
        Group group2 = new Group(102, "Chemistry", 1);
        Group group3 = new Group(103, "Biology", 3);

        Student student1 = new Student(3, "Anna Petrov", group1);
        Student student2 = new Student(2, "Boris Sidorov", group2);
        Student student3 = new Student(1, "Clara Ivanova", group3);

        List<Student> students = Arrays.asList(student1, student2, student3);
        students.sort(new GroupComparator());

        List<Student> expected = Arrays.asList(student2, student1, student3);
        Assert.assertEquals(expected, students);
    }

    @Test
    public void testSortingWithMixedNamesAndGroups() {
        Group group1 = new Group(104, "Engineering", 2);
        Group group2 = new Group(105, "Arts", 1);
        Group group3 = new Group(106, "Medicine", 3);
        Group group4 = new Group(107, "Engineering", 1);

        Student student1 = new Student(4, "Daniel Smirnov", group1);
        Student student2 = new Student(3, "Anna Kozlova", group2);
        Student student3 = new Student(2, "Boris Sidorov", group3);
        Student student4 = new Student(1, "Anna Ivanova", group4);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);


        Collections.sort(students);


        List<Student> expectedByName = Arrays.asList(student4, student2, student3, student1);
        Assert.assertEquals("Сортировка по имени не соответствует ожиданиям",
                expectedByName, students);


        students.sort(new GroupComparator());


        List<Student> expectedByGroup = Arrays.asList(student2, student4, student1, student3);
        Assert.assertEquals("Сортировка по группе не соответствует ожиданиям",
                expectedByGroup, students);
    }
}
