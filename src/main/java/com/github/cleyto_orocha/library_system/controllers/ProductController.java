package com.github.cleyto_orocha.library_system.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cleyto_orocha.library_system.entities.Book;
import com.github.cleyto_orocha.library_system.entities.Paper;
import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    // Product Controller

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @GetMapping
    public List<Product> findAllProduct() {
        return productService.findAllProducts();
    }

    // @DeleteMapping("/{id}")
    // public void deleteProduct(@PathVariable Long id) {
    //     productService.deleteProduct(id);
    // }

    // Books Controller

    @GetMapping("/books/{id}")
    public Product findBookById(@PathVariable Long id) {
        return productService.findBookById(id);
    }

    @PostMapping("/books")
    public Book includeBook(@RequestBody @Valid Book book) {
        return productService.includeBook(book);
    }

    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return productService.findAllBooks();
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        productService.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable @Valid Long id, @RequestBody Book book) {
        return productService.updateBook(book, id);
    }

    // Paper Controller

    @GetMapping("/papers/{id}")
    public Product findPaperById(@PathVariable Long id) {
        return productService.findPaperById(id);
    }

    @GetMapping("/papers")
    public List<Paper> findAllPaper() {
        return productService.findAllPaper();
    }

    @PostMapping("/papers")
    public Paper includePaper(@RequestBody @Valid Paper paper) {
        return productService.includePaper(paper);
    }

    @DeleteMapping("/papers/{id}")
    public void deletePaper(@PathVariable Long id) {
        productService.deletePaper(id);
    }

    @PutMapping("/papers/{id}")
    public Paper updateBook(@PathVariable @Valid Long id, @RequestBody Paper paper) {
        return productService.updatePaper(paper, id);
    }

}
