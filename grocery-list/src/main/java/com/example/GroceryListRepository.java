package org.jhy.grocerylist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryListRepository extends JpaRepository<GroceryList,Long>{}