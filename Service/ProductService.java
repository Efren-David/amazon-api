package com.amazonapi.amazonapi.Service;

import com.amazonapi.amazonapi.Dto.ProductPatchDTO;
import com.amazonapi.amazonapi.Entity.Product;
import com.amazonapi.amazonapi.Exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    Product findProduct(Long id) throws ProductNotFoundException;;

    List<Product> findByCategory(String category);

    List<Product> findByPrice(float price);

    List<Product> findByPriceAndCategory(float price, String categoryName);


    Product addProduct(Product product);

    void deleteProductById(Long productId) throws ProductNotFoundException;

    Product modifyProduct(Long productId, Product product) throws ProductNotFoundException;

    void patchProduct(Long productId, ProductPatchDTO productPatchDTO) throws ProductNotFoundException;



}
