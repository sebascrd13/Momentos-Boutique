package com.boutique.momentos.presentation.controller;

import java.util.List;
import java.util.Optional;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.momentos.domain.domainentity.CartDomain;
import com.boutique.momentos.persistence.entity.User;
import com.boutique.momentos.service.CartService;
import com.boutique.momentos.service.ClientService;

@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<CartDomain> addProductToCart(
            @RequestParam(name = "productId") Integer productId,
            @RequestParam(name = "quantity") Integer quantity,
            Principal principal) {
        
        String username = principal.getName();
        User user = clientService.getClientByUsername(username);
        CartDomain cart = cartService.addProductToCart(user.getIdUser(), productId, quantity);

        return ResponseEntity.ok(cart);
    }

    @PutMapping("/update")
    public ResponseEntity<CartDomain> updateProductQuantity(
            @RequestParam Integer userId,
            @RequestParam Integer productId,
            @RequestParam Integer newQuantity) {
        CartDomain updatedCart = cartService.updateProductQuantity(userId, productId, newQuantity);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> removeProductFromCart(
            Principal principal,
            @RequestParam(name = "productId") Integer productId) {
        String username = principal.getName();
        User user = clientService.getClientByUsername(username);
        boolean removed = cartService.removeProductFromCart(user.getIdUser(), productId);
        if (removed) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearCart(Principal principal) {
        String username = principal.getName();
        User user = clientService.getClientByUsername(username);
        boolean cleared = cartService.clearCart(user.getIdUser());
        if (cleared) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user")
    public ResponseEntity<List<CartDomain>> getCartForUser(Principal principal) {
        String username = principal.getName();
        User user = clientService.getClientByUsername(username);

        List<CartDomain> cartItems = cartService.getCartForUser(user.getIdUser());
        return ResponseEntity.ok(cartItems);
    }

    @GetMapping("/quantity")
    public ResponseEntity<Integer> getProductQuantityInCart(
            @RequestParam Integer userId,
            @RequestParam Integer productId) {
        Optional<Integer> quantity = cartService.getProductQuantityInCart(userId, productId);
        return quantity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
