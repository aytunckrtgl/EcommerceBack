package com.example.demo.model.repository;

import com.example.demo.model.entity.Address;
import com.example.demo.model.entity.CartProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    @Query("select s from Address s where s.user.id = :userId")
    List<Address> findAllAddresses(@Param("userId") long userId);
}
