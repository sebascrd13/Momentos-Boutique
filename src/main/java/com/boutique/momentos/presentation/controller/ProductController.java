package com.boutique.momentos.presentation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boutique.momentos.domain.domainentity.ProductDomain;
import com.boutique.momentos.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDomain>> getAllProducts() {
        List<ProductDomain> products = productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<ProductDomain> saveProduct(@RequestParam("userId") int userId,
                                                    @RequestParam("image") MultipartFile imageFile,
                                                    @RequestParam("productName") String productName,
                                                    @RequestParam("productDescription") String productDescription,
                                                    @RequestParam("productPrice") float productPrice,
                                                    @RequestParam("productStock") int productStock) {
        if (imageFile.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            byte[] imageData = imageFile.getBytes();

            ProductDomain productDomain = new ProductDomain();
            productDomain.setDomainProductUserId(userId);
            productDomain.setDomainProductName(productName);
            productDomain.setDomainProductDescription(productDescription);
            productDomain.setDomainProductPrice(productPrice);
            productDomain.setDomainProductStock(productStock);
            productDomain.setDomainProductImageData(imageData);

            ProductDomain savedProduct = productService.saveProduct(productDomain);

            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDomain> getProductById(@PathVariable("id") int id) {
        Optional<ProductDomain> product = productService.getProductById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
