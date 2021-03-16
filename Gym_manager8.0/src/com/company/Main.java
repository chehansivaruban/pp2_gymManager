package com.company;

import javafx.application.Application;
import javafx.stage.Stage;

import static com.company.Menu.menu;
import static com.company.Menu.readFile;

public class Main extends Application {
        //Main method

    public static void main(String[] args) {
        System.out.println("\n\n==================Welcome To Gym Manager App===========================\n");
    readFile();
	menu(); //calls menu method in menu class
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
    }
}
