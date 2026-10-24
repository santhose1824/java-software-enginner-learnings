package priorityQueue.comparableAndComparator;

import java.util.Objects;

public class StudentMarks implements Comparable<StudentMarks>{
    private int maths;
    private int physics;


    public int getMaths() {
        return maths;
    }

    public int getPhysics() {
        return physics;
    }


    public StudentMarks(int maths, int physics) {
        this.maths = maths;
        this.physics = physics;
    }

    @Override
    public String toString() {
        return "StudentMarks{" +
                "maths=" + maths +
                ", physics=" + physics +
                '}';
    }

    @Override
    public int compareTo(StudentMarks o) {
        // This will give in descending order.
        return -this.maths - o.maths;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentMarks that = (StudentMarks) o;
        return maths == that.maths && physics == that.physics;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maths, physics);
    }
}
