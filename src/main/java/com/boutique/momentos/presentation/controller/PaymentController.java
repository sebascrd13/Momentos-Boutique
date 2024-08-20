package com.boutique.momentos.presentation.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.boutique.momentos.domain.domainentity.PaymentDomain;
import com.boutique.momentos.persistence.entity.User;
import com.boutique.momentos.service.ClientService;
import com.boutique.momentos.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ClientService clientService;

    private static String UPLOADED_FOLDER = "src/main/resources/static/img/";

    @GetMapping
    public ResponseEntity<List<PaymentDomain>> getAllPayments() {
        List<PaymentDomain> payments = paymentService.getAll();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDomain> getPaymentById(@PathVariable("id") int id) {
        Optional<PaymentDomain> payment = paymentService.getPayment(id);
        return payment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PaymentDomain>> getPaymentsByUser(@PathVariable("userId") int userId) {
        Optional<List<PaymentDomain>> payments = paymentService.getByUser(userId);
        return payments.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/upload")
    public ResponseEntity<PaymentDomain> savePayment(@RequestParam("image") MultipartFile imageFile,
                                                     @RequestParam("paymentMethod") String paymentMethod,
                                                     @RequestParam("totalCost") Integer totalCost,
                                                     Principal principal) {
        if (imageFile.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        try {
            String username = principal.getName();
            User user = clientService.getClientByUsername(username);
            
            byte[] bytes = imageFile.getBytes();
            String filename = imageFile.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER + filename);
            Files.write(path, bytes);
    
            PaymentDomain payment = new PaymentDomain();
            payment.setDomainIdUser(user.getIdUser());
            payment.setDomainImageData("img/" + filename);
            payment.setDomainPaymentDate(LocalDateTime.now());
            payment.setDomainPaymentStatus(false);
            payment.setDomainPaymentMethod(paymentMethod);
            payment.setDomainPaymentTotalCost(totalCost);
    
            PaymentDomain savedPayment = paymentService.savePayment(payment);
            return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
            
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable("id") int id) {
        boolean deleted = paymentService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}