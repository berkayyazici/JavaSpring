package com.Berkay.InterProbe.InterProbeBootcamp.Controller;

import com.Berkay.InterProbe.InterProbeBootcamp.Dao.ProductDao;
import com.Berkay.InterProbe.InterProbeBootcamp.Entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductDao productDao;

    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.ok(productDao.save(product));
    }

    @GetMapping()
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productDao.findAll());
    }

    @GetMapping("/expiredorexpirationdateisnull/{date}")
    public ResponseEntity<List<Product>> findAllByNotExpiredOrExpirationDateIsNull(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return ResponseEntity.ok(productDao.findAllByNotExpiredOrExpirationDateIsNull(date));
    }

    @GetMapping("/expireddate/{date}")
    public ResponseEntity<List<Product>> findAllByExpiredDate(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return ResponseEntity.ok(productDao.findAllByExpiredDate(date));
    }
}
