package com.netcracker;

import com.netcracker.domain.StreamTest;
import com.netcracker.domain.Student;
import com.netcracker.domain.suppliers.SupplierStudents;

import java.util.List;

public class CollectorTest {
    public static void main(String[] args) {
        SupplierStudents supplierStudents = new SupplierStudents();
        List<Student> students = supplierStudents.get();

        StreamTest.testMyCollector(students);
    }
}
