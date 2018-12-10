package organic.organic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import organic.organic.dao.ServiceResult;
import organic.organic.dao.product.ProductService;
import organic.organic.model.product.Product;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    /* ---------------- GET ALL USER ------------------------ */
    @GetMapping("/products")
    public @ResponseBody java.util.List<Product> findAllCustomer() {
        return productService.findAll();
    }
    /* ---------------- GET USER BY ID ------------------------ */
    @GetMapping("/product/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(productService.findById(id), HttpStatus.OK);
    }
    /* ---------------- CREATE NEW USER ------------------------ */
    @PostMapping("/product")
    public ResponseEntity<ServiceResult> create(@RequestBody Product product ) {
        return new ResponseEntity<ServiceResult>(productService.create(product), HttpStatus.OK);
    }

    /* ---------------- UPDATE USER ------------------------ */
    @PutMapping("/product/{id}")
    public ResponseEntity<ServiceResult> update(@RequestBody Product product, @PathVariable int id) {
    	product.setId(id);
        return new ResponseEntity<ServiceResult>(productService.update(product), HttpStatus.OK);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(productService.delete(id), HttpStatus.OK);
    }
}
