package vendedor1;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

	@Configuration


	@Slf4j
	class BDD {

	    Logger log = LoggerFactory.getLogger (vendedor_1.class);
	    @Bean
	    CommandLineRunner initDatabase(vendedores_repositorio repositoryvendedor, Orden_Repositorio repositoryOrden) {
	        return args -> {
	            
	           log.info("ibuprofeno " + repositoryvendedor.save(new vendedores( " sucursal.calacoto")));

	            repositoryOrden.save(new Orden("Megacenter", Orden_Status.COMPLETED));
	            repositoryOrden.save(new Orden("torre Ketal", Orden_Status.IN_PROGRESS));

	            repositoryOrden.findAll().forEach(order -> {
	                log.info("aspirina " + order);
	            });

	        };
	        
	    }
}
