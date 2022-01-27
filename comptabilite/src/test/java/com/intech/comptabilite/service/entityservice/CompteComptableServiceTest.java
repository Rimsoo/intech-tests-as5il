
package com.intech.comptabilite.service.entityservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.intech.comptabilite.model.CompteComptable;
import com.intech.comptabilite.repositories.CompteComptableRepository;

@SpringBootTest
public class CompteComptableServiceTest {
	
	@MockBean 
	private CompteComptableRepository compteComptableRepository;

	@Autowired 
	CompteComptableService compteComptableService;

	    @Test
	    public void testGetByNumeroCompteComptableIfExists() {
	       CompteComptable compteComptable = new CompteComptable();
	       compteComptable.setNumero(454);
	       compteComptable.setLibelle("test");


	       List<CompteComptable> listCompteComptable = new ArrayList<CompteComptable>();
	       listCompteComptable.add(compteComptable);

	       CompteComptable result = compteComptableService.getByNumero(listCompteComptable, 454);

	       Assertions.assertNotNull(result);
	       Assertions.assertEquals(result.getNumero(), compteComptable.getNumero());
	       Assertions.assertEquals(result.getLibelle(), compteComptable.getLibelle());
	    }

	    @Test
	    public void testGetByNumeroNullIfNotExists() {
	       CompteComptable compteComptable = new CompteComptable();
	       compteComptable.setNumero(1);
	       compteComptable.setLibelle("test");


	       List<CompteComptable> listCompteComptable = new ArrayList<CompteComptable>();
	       listCompteComptable.add(compteComptable);

	       CompteComptable result = compteComptableService.getByNumero(listCompteComptable, 3);

	       Assertions.assertNull(result);
	    }
	    
	    @Test
	    public void unitTestGetListCompteComptable() {
	    	List<CompteComptable> list = new ArrayList<CompteComptable>();
	    	CompteComptable compteComptable = new CompteComptable();
	    	compteComptable.setNumero(1999);
	    	list.add(compteComptable);
	    	list.add(new CompteComptable());

	    	Mockito.when(compteComptableRepository.findAll()).thenReturn(list);

	    	List<CompteComptable> result = compteComptableService.getListCompteComptable();

	    	Assertions.assertEquals(list.size(), result.size());
	    	Assertions.assertEquals(list.get(0).getNumero(), compteComptable.getNumero());

	    }

}