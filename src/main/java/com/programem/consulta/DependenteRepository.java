package com.programem.consulta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DependenteRepository extends CrudRepository<Dependente, Integer> {

    @Query(
    value = "SELECT * FROM cliente WHERE cliente.idade >= :idade", 
     nativeQuery = true)
    Iterable<Dependente> findIdadeDependente(@Param("idade") Integer idade);
}