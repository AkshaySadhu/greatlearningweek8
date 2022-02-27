package com.greatlearning.week8.repository;

import com.greatlearning.week8.Model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
    Items findItemsByItemName(String itemName);

}
