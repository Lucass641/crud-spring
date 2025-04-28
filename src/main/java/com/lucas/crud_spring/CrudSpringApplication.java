package com.lucas.crud_spring;

import com.lucas.crud_spring.enums.Category;
import com.lucas.crud_spring.model.Lesson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lucas.crud_spring.model.Course;
import com.lucas.crud_spring.repository.CourseRepository;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class CrudSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringApplication.class, args);
    }

    @Bean
    @Profile("dev")
    CommandLineRunner initDatabase(CourseRepository courseRepository) {
        return args -> {
            courseRepository.deleteAll();

            for (int i = 0; i < 20; i++) {

                Course c = new Course();
                c.setName("Angular com Spring" + i);
                c.setCategory(Category.FRONT_END);

                Lesson l = new Lesson();
                l.setName("Introdução");
                l.setYoutubeUrl("watch?11v=1");
                l.setCourse(c);
                c.getLessons().add(l);

                Lesson l1 = new Lesson();
                l1.setName("Angular");
                l1.setYoutubeUrl("watch?11v=2");
                l1.setCourse(c);
                c.getLessons().add(l1);

                courseRepository.save(c);
            }
        };
    }
}
