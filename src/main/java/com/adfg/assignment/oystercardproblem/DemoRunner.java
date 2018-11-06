package com.adfg.assignment.oystercardproblem;

import com.adfg.assignment.oystercardproblem.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.adfg.assignment.oystercardproblem.service.IOysterCardService;

import java.util.Scanner;

@Component
public class DemoRunner implements CommandLineRunner{

    private final IOysterCardService oysterCardService;

    @Autowired
    public DemoRunner(IOysterCardService oysterCardService){
        this.oysterCardService = oysterCardService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To create an Oyster card, press <enter>");
        scanner.nextLine();
        Card card = oysterCardService.createCard();
        System.out.println("To add 30 in your Oyster card, press <enter>");
        scanner.nextLine();
        oysterCardService.addBalance(card.getId(),30.00);
        System.out.println("card loaded");
        System.out.println("To check in Tube at Holborn , press <enter>");
        scanner.nextLine();
        oysterCardService.checkIn(card.getId(),1,2);
        System.out.println("checkin successfully");
        oysterCardService.viewBalance(card);
        System.out.println("To check out at Tube Earl’s Court , press <enter>");
        scanner.nextLine();
        oysterCardService.checkout(card.getId(),2);
        System.out.println("checkout successfully");
        oysterCardService.viewBalance(card);
        System.out.println("To check in 328 bus at Earl’s Court , press <enter>");
        scanner.nextLine();
        oysterCardService.checkIn(card.getId(),2,1);
        System.out.println("checkin successfully");
        oysterCardService.viewBalance(card);
        System.out.println("To check out at Chelsea , press <enter>");
        scanner.nextLine();
        oysterCardService.checkout(card.getId(),6);
        System.out.println("checkout successfully");
        oysterCardService.viewBalance(card);
        System.out.println("To check in at Tube Earl’s Court , press <enter>");
        scanner.nextLine();
        oysterCardService.checkIn(card.getId(),2,2);
        System.out.println("checkin successfully");
        oysterCardService.viewBalance(card);
        System.out.println("To check out at Hammersmith , press <enter>");
        scanner.nextLine();
        oysterCardService.checkout(card.getId(), 3);
        System.out.println("checkout successfully");
        oysterCardService.viewBalance(card);

    }
}
