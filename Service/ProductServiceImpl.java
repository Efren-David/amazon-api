package com.amazonapi.amazonapi.Service;

import com.amazonapi.amazonapi.Dto.ProductPatchDTO;
import com.amazonapi.amazonapi.Entity.Product;
import com.amazonapi.amazonapi.Exception.ProductNotFoundException;
import com.amazonapi.amazonapi.Repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product findProduct(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException ::new);
    }

    @Override
    public List<Product> findByCategory(String categoryName) {

        return productRepository.findByCategory(categoryName);
    }


    @Override
    public List<Product> findByPrice(float price) {
        return productRepository.findByPrice(price);

    }

    @Override
    public List<Product> findByPriceAndCategory(float price, String categoryName) {
        return productRepository.findByPriceAndCategory(price, categoryName);
    }

    @Override
    public Product addProduct(Product product) {
        product.setCreateDate(LocalDate.now());
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long productId) throws ProductNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
        productRepository.delete(product);
    }

    @Override
    public Product modifyProduct(Long productId, Product product) throws ProductNotFoundException {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
        modelMapper.map(product, existingProduct);
        existingProduct.setId(productId);
        return productRepository.save(existingProduct);
    }

    @Override
    public void patchProduct(Long productId, ProductPatchDTO productPatchDTO) throws ProductNotFoundException {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
        if (productPatchDTO.getField().equals("price")) {
            existingProduct.setPrice(Float.parseFloat(productPatchDTO.getValue()));
        }

        productRepository.save(existingProduct);
    }




}
