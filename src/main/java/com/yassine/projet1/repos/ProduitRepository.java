package com.yassine.projet1.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yassine.projet1.entities.Categorie;
import com.yassine.projet1.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom);
	
	@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
		List<Produit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	@Query("select p from Produit p where p.categorie = :nomC")
	List<Produit> findByCategorie (@Param("nomC") Categorie categorie);
	
	List<Produit> findByCategorieIdCat(Long id);	
	List<Produit> findByOrderByNomProduitAsc();
	
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> trierProduitsNomsPrix ();


}
