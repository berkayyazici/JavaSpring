package com.Berkay.InterProbe.InterProbeBootcamp.Dao;

import com.Berkay.InterProbe.InterProbeBootcamp.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    @Query("FROM Product WHERE expirationDate >= :date or expirationDate is null")
    List<Product> findAllByNotExpiredOrExpirationDateIsNull(Date date);

    @Query("FROM Product WHERE expirationDate < :date")
    List<Product> findAllByExpiredDate(Date date);
}
