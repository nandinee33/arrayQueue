package main;

import definition.arrayQueue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        arrayQueue<String> queue = new arrayQueue<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the choice1");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                System.out.println("enter the name");
                String name = sc.nextLine();
                queue.offer(name);
                break;
            case 2:
                queue.peek();
                break;
            case 3:
                queue.poll();
                break;
            default:
                System.out.println(queue);
                break;
        }


    }
}
