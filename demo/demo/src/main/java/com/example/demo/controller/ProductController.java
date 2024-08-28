package com.example.demo.controller;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/")
    public String showProductList(Model model) {
        List<ProductEntity> products = (List<ProductEntity>) productRepository.findAll();
        model.addAttribute("products", products);
        return "product";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") int id, Model model) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
            model.addAttribute("product", product);
            return "productform";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/products/save")
    public String saveProduct (@ModelAttribute("") ProductEntity product) {
        productRepository.save(product);
        return "redirect:/";
    }
    @GetMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
        return "redirect:/";
    }

}
