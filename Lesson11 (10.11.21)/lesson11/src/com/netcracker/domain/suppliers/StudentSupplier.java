package com.netcracker.domain.suppliers;

import com.netcracker.domain.Student;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class StudentSupplier implements Supplier<Student> {

    private List<Student> students;

    public StudentSupplier(List<Student> students) {
        this.students = students;
    }

    @Override
    public Student get() {
        int index = ThreadLocalRandom.current().nextInt(students.size());
        return students.get(index);
    }
}
