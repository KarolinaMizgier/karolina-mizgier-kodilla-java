package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class BoardTestSuite {
    @Test
    void testBoard(){
    //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When & Then
        board.getDoneList();
        board.getInProgressList();
        board.getToDoList();
    }

    @Test
    void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.toDoList.taskAdd("Task TODO");
        board.inProgressList.taskAdd("Task In Progress");
        board.doneList.taskAdd("Task Done");
        //Then
        System.out.println("TODO list: "+board.toDoList.toString());
        System.out.println("In progress list: "+board.inProgressList.toString());
        System.out.println("Done list: "+board.doneList.toString());
    }

}
