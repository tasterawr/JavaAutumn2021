package com.example.spring_data_lesson;

import com.example.spring_data_lesson.model.Star;
import com.example.spring_data_lesson.repo.PlanetRepository;
import com.example.spring_data_lesson.repo.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
public class Test {
    private ApplicationContext context;
    private StarRepository starRepository;

    @Autowired
    public Test(ApplicationContext context, StarRepository starRepository){
        this.context = context;
        this.starRepository = starRepository;
    }

    @PostConstruct
    public void init(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1. Создать звезду");
            System.out.println("2. Обновить звезду по Id");
            System.out.println("3. Получить звезду по Id");
            System.out.println("4. Получить все звезды");
            System.out.println("5. Удалить звезду по Id");

            int option = Integer.parseInt(scanner.nextLine());
            switch (option){
                case 1:
                    createStar();
                    break;
                case 2:
                    updateStar();
                    break;
                case 3:
                    getStar();
                    break;
                case 4:
                    getAllStars();
                    break;
                case 5:
                    deleteStar();
                    break;
                default:
            }

        }
    }

    private void deleteStar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id звезды");
        int id = Integer.parseInt(scanner.nextLine());

        starRepository.deleteById(id);
    }

    private void getAllStars() {
        for (Star star : starRepository.findAll()){
            System.out.println(star);
        }
    }

    private Star getStar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id звезды");
        int id = Integer.parseInt(scanner.nextLine());
        Star star = starRepository.findById(id).orElse(new Star());
        System.out.println(star);

        return star;
    }

    private void updateStar() {
        Scanner scanner = new Scanner(System.in);
        Star star = getStar();
        System.out.println("Введите новое название звезды");
        String name = scanner.nextLine();
        star.setName(name);
        starRepository.save(star);
    }

    public void createStar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название звезды");
        String name = scanner.nextLine();

        Star star = new Star();
        star.setName(name);
        starRepository.save(star);
    }
}
