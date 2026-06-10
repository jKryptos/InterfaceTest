package ui;

import java.util.Scanner;

public class UI {

    protected Scanner scanner;

    public UI(){
        this.scanner = new Scanner(System.in);
    }

    public String getMessage(String message){
        return message;
    }
}
