package com.example.demo.model.repository;

import com.example.demo.model.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
