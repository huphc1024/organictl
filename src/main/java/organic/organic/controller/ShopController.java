package organic.organic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.organic.dao.user.RoleService;
import organic.organic.dao.ServiceResult;
import organic.organic.dao.product.ShopService;
import organic.organic.model.product.Product;
import organic.organic.model.product.Shop;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class ShopController {
        @Autowired
        private ShopService shopService ;

        /* ---------------- GET ALL ROLE ------------------------ */
        @GetMapping("/shops")
        public @ResponseBody java.util.List<Shop> findAllShop() {
            return (List<Shop>) shopService.findAll();
        }
        /* ---------------- GET ROLE BY ID ------------------------ */
        @GetMapping("/shop/{id}")
        public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
            return new ResponseEntity<ServiceResult>(shopService.findById(id), HttpStatus.OK);
        }
        /* ---------------- CREATE NEW ROLE ------------------------ */
        @PostMapping("/shop")
        public ResponseEntity<ServiceResult> create(@RequestBody Shop shop) {
            return new ResponseEntity<ServiceResult>(shopService.create(shop), HttpStatus.OK);
        }

        /* ---------------- UPDATE ROLE ------------------------ */
        @PutMapping("/shop/{id}")
        public ResponseEntity<ServiceResult> update(@RequestBody Shop shop, @PathVariable int id) {
        	shop.setId(id);
            return new ResponseEntity<ServiceResult>(shopService.update(shop), HttpStatus.OK);
        }
        @DeleteMapping("/shop/{id}")
        public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
            return new ResponseEntity<ServiceResult>(shopService.delete(id), HttpStatus.OK);
        }
}

