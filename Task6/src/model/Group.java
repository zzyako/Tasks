package model;

import java.util.Objects;

public class Group {
    private int groupId;
    private String groupName;
    private int course;

    public Group(int groupId, String groupName, int course) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.course = course;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getCourse() {
        return course;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;
        return groupId == group.groupId &&
                course == group.course &&
                Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName, course);
    }

    @Override
    public String toString() {
        return "Group{id=" + groupId +
                ", name='" + groupName + '\'' +
                ", course=" + course +
                '}';
    }
}
