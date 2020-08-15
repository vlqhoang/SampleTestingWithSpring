package com.practice.utesting.unittesting.repos;

import com.practice.utesting.unittesting.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {


}
