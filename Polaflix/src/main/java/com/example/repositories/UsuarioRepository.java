package com.example.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domainModel.Capitulo;
import com.example.domainModel.CapituloVisto;
import com.example.domainModel.EspacioPersonal;
import com.example.domainModel.FacturaCobrada;
import com.example.domainModel.MarcadorSerie;
import com.example.domainModel.Serie;
import com.example.domainModel.Usuario;
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByNombreUsuario(String nombre);
	
	@Query("select c.capitulo from CapituloVisto c, FacturaCobrada f where "
			+ "f.id = ?1")
	List<Capitulo> findVisualizacionesByFacturaCobrada(Long id);
		
	@Query("select u.facturasCobradas from Usuario u where u.nombreUsuario = ?1")
	List<FacturaCobrada> findFacturasCobradas(String nombre);
	
	@Query("select u.facturasCobradas from Usuario u, FacturaCobrada f where "
			+ "u.nombreUsuario = ?1 and f.fecha = ?2")
	FacturaCobrada findFacturaCobrada(String nombre, Date f);
		
	@Query("select u.espacioPersonal from Usuario u where u.nombreUsuario = ?1")
	EspacioPersonal findEspacioPersonalByUser(String nombre);

	@Query("select e.marcadoresSeries from EspacioPersonal e where e.id = ?1")
	List<MarcadorSerie> findSeriesEmpezadasByEP(Long id);
		
	@Query("select e.seriesPendientes from EspacioPersonal e where e.id = ?1")
	List<Serie> findSeriesPendientesByEP(Long id);
	
	@Query("select e.seriesFinalizadas from EspacioPersonal e where e.id = ?1")
	List<Serie> findSeriesFinalizadasByEP(Long id); 
	
	@Query("select e.capitulosVistos from EspacioPersonal e where e.id = ?1")
	List<Capitulo> findCapitulosVistosByEP(Long id);
	
	Usuario save(Usuario u);
	
	FacturaCobrada save(FacturaCobrada f);
	
	MarcadorSerie save(MarcadorSerie ms);
}
