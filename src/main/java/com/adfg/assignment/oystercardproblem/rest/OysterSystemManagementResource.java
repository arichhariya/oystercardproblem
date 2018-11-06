//package com.adfg.assignment.oystercardproblem.rest;
//
//import com.adfg.assignment.oystercardproblem.exceptions.CardNotValidException;
//import com.adfg.assignment.oystercardproblem.model.Card;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import com.adfg.assignment.oystercardproblem.service.IOysterCardService;
//
//@RestController
//@RequestMapping("/app/oystercardsystem")
//public class OysterSystemManagementResource {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(OysterSystemManagementResource.class);
//
//    @Autowired
//    IOysterCardService oysterCardService;
//
//
//    @ResponseBody
//    @RequestMapping(value = "/checkin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Card checkIn(Integer cardNo, Integer stationCode, Integer journeyType) {
//        Card card = null;
//             card = oysterCardService.checkIn(cardNo, stationCode, journeyType);
//        return card;
//    }
//
//    public Card checkOut(Integer cardNo, Integer stationCode) {
//        Card card = oysterCardService.checkout(cardNo, stationCode);
//        oysterCardService.viewBalance(card);
//        return card;
//
//    }
//
//    public void addBalance(Integer cardNo, Double balance) {
//        oysterCardService.addBalance(cardNo, balance);
//
//    }
//
//    public Card creatCard() {
//        Card card = oysterCardService.createCard();
//        return card;
//    }
//}
