package com.netcracker;

import com.netcracker.domain.Faculty;
import com.netcracker.domain.Student;
import com.netcracker.domain.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StudentPairCollector implements Collector<Student, List<Pair<String, Faculty>>, List<Pair<String, Faculty>>> {
    public static void main(String[] args) {

    }

    public static StudentPairCollector toStudentPairList(){
        return new StudentPairCollector();
    }

    @Override
    public Supplier<List<Pair<String, Faculty>>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Pair<String, Faculty>>, Student> accumulator() {
        return (list, student) -> list.add(new Pair<>(student.getName(), student.getFaculty()));
    }

    @Override
    public BinaryOperator<List<Pair<String, Faculty>>> combiner() {
        return (firstList, secondList) -> {
            firstList.addAll(secondList);
            return firstList;
        };
    }

    @Override
    public Function<List<Pair<String, Faculty>>, List<Pair<String, Faculty>>> finisher() {
        return Collections::unmodifiableList;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}
