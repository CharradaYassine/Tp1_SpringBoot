package com.yassine.projet1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yassine.projet1.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
}
