package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final String VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

    private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}	


    @GetMapping(value = "/create")
	public String initCreationForm(ModelMap model) {
		model.addAttribute("product", new Product());
        model.addAttribute("productType", productService.findAllProductTypes());
		return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
	}



	@PostMapping(value = "/create")
	public String processCreationForm(@Valid Product product, BindingResult result) {		
        String view = "welcome";
		if (result.hasErrors()) {
            return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
		}
        productService.save(product);
        return view;
	
    }
}
