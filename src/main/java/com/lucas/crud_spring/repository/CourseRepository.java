package com.lucas.crud_spring.repository;

import org.springframework.stereotype.Repository;

import com.lucas.crud_spring.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    
}
