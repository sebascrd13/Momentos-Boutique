package com.boutique.momentos.presentation.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    private static String UPLOADED_FOLDER = "src/main/resources/static/img/";

    @GetMapping
    public ResponseEntity<List<ProductDomain>> getAllProducts() {
        List<ProductDomain> products = productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<ProductDomain> saveProduct(@RequestParam("imageFile") MultipartFile file,
                                             @RequestParam("userId") Integer userId,
                                             @RequestParam("productName") String productName,
                                             @RequestParam("productDescription") String productDescription,
                                             @RequestParam("productPrice") Float productPrice,
                                             @RequestParam("productStock") Integer productStock,
                                             @RequestParam("categoryId") Integer categoryId,
                                             @RequestParam("productSize") Character productSize) {

        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            byte[] bytes = file.getBytes();
            String filename = file.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER + filename);
            Files.write(path, bytes);

            ProductDomain productDomain = new ProductDomain();
            productDomain.setDomainProductUserId(userId);
            productDomain.setDomainProductName(productName);
            productDomain.setDomainProductImagePath("img/" + filename);
            productDomain.setDomainProductDescription(productDescription);
            productDomain.setDomainProductPrice(productPrice);
            productDomain.setDomainProductStock(productStock);
            productDomain.setDomainProductCategoryId(categoryId);
            productDomain.setDomainProductSize(productSize);

            ProductDomain savedProduct = productService.saveProduct(productDomain);

            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDomain> updateProduct(@PathVariable("id") int id,
                                                       @RequestParam("userId") int userId,
                                                       @RequestParam("imageFile") MultipartFile file,
                                                       @RequestParam("productName") String productName,
                                                       @RequestParam("productDescription") String productDescription,
                                                       @RequestParam("productPrice") float productPrice,
                                                       @RequestParam("productSize") char productSize,
                                                       @RequestParam("productStock") int productStock,
                                                       @RequestParam("categoryId") int categoryId) {
        try {
            String imagePath = null;
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String filename = file.getOriginalFilename();
                Path path = Paths.get(UPLOADED_FOLDER + filename);
                Files.write(path, bytes);
                imagePath = "img/" + filename;
            }

            ProductDomain productDomain = new ProductDomain();
            productDomain.setDomainProductId(id);
            productDomain.setDomainProductUserId(userId);
            productDomain.setDomainProductName(productName);
            productDomain.setDomainProductDescription(productDescription);
            productDomain.setDomainProductPrice(productPrice);
            productDomain.setDomainProductStock(productStock);
            productDomain.setDomainProductSize(productSize);
            if (imagePath != null) {
                productDomain.setDomainProductImagePath(imagePath);
            }
            productDomain.setDomainProductCategoryId(categoryId);

            ProductDomain updatedProduct = productService.updateProduct(productDomain);

            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDomain> getProductById(@PathVariable("id") int id) {
        Optional<ProductDomain> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {
        boolean deleted = productService.deleteProduct(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ProductDomain> updateProductStatus(@PathVariable("id") int id, @RequestBody StatusUpdateRequest statusUpdateRequest) {
        Optional<ProductDomain> productOpt = productService.getProductById(id);
        if (productOpt.isPresent()) {
            ProductDomain product = productOpt.get();
            System.out.println(product.getDomainProductName());
            product.setDomainProductStatus(statusUpdateRequest.getStatus());
            System.out.println(product.getDomainProductStatus());
            ProductDomain updatedProduct = productService.updateProduct(product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public static class StatusUpdateRequest {
        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}