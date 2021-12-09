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
        board.getToDoList().taskAdd("Task TODO");
        board.getInProgressList().taskAdd("Task In Progress");
        board.getDoneList().taskAdd("Task Done");
        //Then
        System.out.println("TODO list: "+board.getToDoList().toString());
        System.out.println("In progress list: "+board.getInProgressList().toString());
        System.out.println("Done list: "+board.getDoneList().toString());
    }

}
