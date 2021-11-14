package com.netcracker.domain;

import com.netcracker.StudentPairCollector;
import com.netcracker.domain.suppliers.StudentSupplier;
import com.netcracker.domain.suppliers.SupplierStudents;
import com.netcracker.domain.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Student firstStudent = new Student(19, "Иван", Faculty.CSIT);
        Student secondStudent = new Student(20, "Ваня", Faculty.CSIT);

        SupplierStudents supplierStudents = new SupplierStudents();
        List<Student> students = supplierStudents.get();
        StudentSupplier studentSupplier = new StudentSupplier(supplierStudents.get());

        Stream<Student> firstStream =
                Stream.of(firstStudent, secondStudent);

        Stream<Student> secondStream = Stream.<Student>builder()
                .add(firstStudent)
                .add(secondStudent)
                .build();

        Stream<Student> concat = Stream.concat(firstStream, secondStream);

        Stream<Student> stream = supplierStudents.get().stream();

//        Stream.generate(studentSupplier)
//                .limit(10)
//                .forEach(System.out::println);
//        testReduce();
//        testStream(students).forEach(System.out::println);
//        String s1 = testFindFirst(students)
//                .orElse("1");
//        String s2 = testFindFirst(students)
//                .orElseGet(Student::alternativeValueForOptional);
//        System.out.println(s1);
//        System.out.println(s2);


        students.stream()
                .filter(student ->
                        student.getFaculty().equals(Faculty.CSIT) ||
                                student.getFaculty().equals(Faculty.ECONOMICS))
                .collect(
                        Collectors.toMap(Student::getName, Student::getFaculty)
                )
                .forEach((key, value) -> System.out.println(key + " : " + value));

        students.stream()
                .filter(student ->
                        student.getFaculty().equals(Faculty.CSIT) ||
                                student.getFaculty().equals(Faculty.ECONOMICS))
                .collect(
                        Collectors.toMap(
                                Student::getFaculty,
                                (student) -> new ArrayList<String>() {{
                                    add(student.getName());
                                }},
                                (firstList, secondList) -> {
                                    firstList.addAll(secondList);
                                    return firstList;
                                })
                )
                .forEach((key, value) -> System.out.println(key + " : " + value));

        students.stream()
                .filter(student ->
                        student.getFaculty().equals(Faculty.CSIT) ||
                                student.getFaculty().equals(Faculty.ECONOMICS))
                .collect(
                        Collectors.groupingBy(
                                Student::getFaculty, Collectors.mapping(Student::getName, Collectors.toList())
                ))
                .forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public static List<String> testList(List<Student> list) {

        List<String> names = new ArrayList<>();
        for (Student student : list) {
            if (student.getAge() >= 20 && student.getFaculty().equals(Faculty.CSIT)) {
                names.add(student.getName());
            }
        }
        return names;
    }

    public static List<String> testStream(List<Student> students) {
        return students.stream()
                .filter(student -> student.getAge() > 19 && student.getFaculty().equals(Faculty.CSIT))
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static Optional<String> testFindFirst(List<Student> students) {
        return students.stream()
                .filter(student -> student.getAge() > 30 && student.getFaculty().equals(Faculty.CSIT))
                .map(Student::getName)
                .findFirst();
    }

    public static void testReduce() {
        int sum = IntStream.of(1, 2, 3, 5).sum();
        Integer reduce = Stream.of(1, 2, 3, 5).reduce(0, (first, second) -> first + second);
        System.out.println(sum);
        System.out.println(reduce);
    }

    public static void testMyCollector(List<Student> students){
        List<Pair<String, Faculty>> pairs = students.stream()
                .filter(student -> student.getAge() < 20)
                .collect(StudentPairCollector.toStudentPairList());

        pairs.forEach(System.out::println);
    }
}
