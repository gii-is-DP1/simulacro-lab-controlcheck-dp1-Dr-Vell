package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class ProductService {

    private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}	

    public List<ProductType> findAllProductTypes(){
        return productRepository.findAllProductTypes();
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductByName(String s){
        return productRepository.findByName(s);
    }    

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productRepository.findProductTypeByName(typeName);
    }

    public Product save(Product p){
        return productRepository.save(p);       
    }

    
}
