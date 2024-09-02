package com.amazonapi.amazonapi.Controller;

import com.amazonapi.amazonapi.Dto.ErrorResponse;
import com.amazonapi.amazonapi.Dto.ProductPatchDTO;
import com.amazonapi.amazonapi.Entity.Product;
import com.amazonapi.amazonapi.Exception.ProductNotFoundException;
import com.amazonapi.amazonapi.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller

@RestController
@RequestMapping("/api/v1")

public class ProductController {

    @Autowired
    private ProductService productService;

    // Add product
    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }


    // Remove product
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long productId) throws ProductNotFoundException {
        productService.deleteProductById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Modify product
    @PutMapping("/product/{productId}")
    public ResponseEntity<Product> modifyProduct(@PathVariable long productId, @RequestBody Product product) throws ProductNotFoundException {
        Product newProduct = productService.modifyProduct(productId, product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    // Modify product (patch)
    @PatchMapping("/product/{productId}")
    public ResponseEntity<Void> patchProduct(@PathVariable long productId, @RequestBody ProductPatchDTO productPatchDTO) throws ProductNotFoundException {
        productService.patchProduct(productId, productPatchDTO);
        return ResponseEntity.noContent().build();
    }

    // See all products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        // Llama al servicio para obtener todos los productos
        List<Product> products = productService.findAllProducts();

        // Devuelve todos los productos en la respuesta con código 200 OK
        return ResponseEntity.ok(products);
    }


    // See a product
    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable long productId) throws ProductNotFoundException {
        Product product = productService.findProduct(productId);
        return ResponseEntity.ok(product);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ProductNotFoundException pnfe) {
        ErrorResponse errorResponse = new ErrorResponse(101, pnfe.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(999, "Error interno del servidor");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }







}
