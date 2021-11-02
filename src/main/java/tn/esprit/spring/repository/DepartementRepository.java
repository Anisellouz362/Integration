package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, Integer>{
	
	@Query("SELECT d FROM Departement")
	public Departement getDepartement();
	

	@Query("SELECT count(*) FROM Departement")
    public int countdep();
	

    
    @Query("Select "
			+ "join emp.departements dps "
			+ "join dps.entreprise entrep "
			+ "where entrep=:entreprise")
    public List<Departement> getAllDepartementByEntreprisec(@Param("entreprise") Entreprise entreprise);
    
    @Modifying
    @Transactional
    @Query("UPDATE Employe e SET e.email=:email1 where e.id=:employeId")
    public void mettreAjourDepartementIdJPQL(@Param("departement")String departement, @Param("departementId")int departementId);

    
    @Modifying
    @Transactional
    @Query("DELETE from Departement")
    public void deleteAllDepartementJPQL();
  
    
}
