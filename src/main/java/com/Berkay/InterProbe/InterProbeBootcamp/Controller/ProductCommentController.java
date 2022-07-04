package com.Berkay.InterProbe.InterProbeBootcamp.Controller;

import com.Berkay.InterProbe.InterProbeBootcamp.Dao.ProductCommentDao;
import com.Berkay.InterProbe.InterProbeBootcamp.Entities.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class ProductCommentController {

    private final ProductCommentDao productCommentDao;

    @PostMapping()
    public ResponseEntity<ProductComment> save(@RequestBody ProductComment productComment) {
        return ResponseEntity.ok(productCommentDao.save(productComment));
    }

    @GetMapping()
    public ResponseEntity<List<ProductComment>> findAll() {
        return ResponseEntity.ok(productCommentDao.findAll());
    }

    @GetMapping("/productid/{productId}")
    public ResponseEntity<List<ProductComment>> findAllByProduct_Id(@PathVariable Long productId) {
        return ResponseEntity.ok(productCommentDao.findAllByProduct_Id(productId));
    }

    @GetMapping("/productidandcommentdatebetween/{productId}/{start}/{end}")
    public ResponseEntity<List<ProductComment>> findAllByProduct_IdAndCommentDateBetween(
            @PathVariable Long productId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        return ResponseEntity.ok(productCommentDao.findAllByProduct_IdAndCommentDateBetween(productId, start, end));
    }

    @GetMapping("/userid/{userId}")
    public ResponseEntity<List<ProductComment>> findAllByUser_Id(@PathVariable Long userId) {
        return ResponseEntity.ok(productCommentDao.findAllByUser_Id(userId));
    }

    @GetMapping("/useridandcommentdatebetween/{userId}/{start}/{end}")
    public ResponseEntity<List<ProductComment>> findAllByUser_IdAndCommentDateBetween(
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        return ResponseEntity.ok(productCommentDao.findAllByUser_IdAndCommentDateBetween(userId, start, end));
    }

}
