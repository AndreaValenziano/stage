package com.purepay;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NavTypeRepository extends JpaRepository<NavigationType,Integer> {
    NavigationType findById(int id);
}
