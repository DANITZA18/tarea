package vendedor1;


	import java.net.URI;
	import java.net.URISyntaxException;
	import java.util.List;
	import java.util.stream.Collectors;

	import org.springframework.hateoas.Resource;
	import org.springframework.hateoas.Resources;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

	import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
	import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

	@RestController
	class vendedores_controlador {

	    private final vendedores_Repositorio repository;

	    private final vendedores_Resource assembler;

	    vendedores_Controlador(vendedores_Repositorio repository, vendedores_Assemble_Resource assembler) {
	        this.repository = repository;
	        this.assembler = assembler;
	    }

	    // Aggregate root
	/*
	    @GetMapping("/buses")
	     List<Buses> all() {
	        return repository.findAll();
	    }
	*/

	    @PostMapping("/vendedores")
	    ResponseEntity<?> newEmployee(@RequestBody vendedores newEmployee) throws URISyntaxException {

	        Resource<Buses> resource = vendedores.toResource(repository.save(newEmployee));

	        return ResponseEntity
	                .created(new URI(resource.getId().expand().getHref()))
	                .body(resource);
	    }

	    // Single item

	    // se cambio one por ones

	    @GetMapping("/vendedores/{id}")
	    Resource<vendedores> ones(@PathVariable Long id) {

	        vendedores employee = repository.findById(id)
	                .orElseThrow(() -> new BusNotFoundException(id));

	        return assembler.toResource(employee);
	    }

	    @PutMapping("/vendedores/{id}")
	    vendedores replaceEmployee(@RequestBody vendedores newBus, @PathVariable Long id) {

	        return repository.findById(id)
	                .map(vendedores -> {
	                    vendedor.setName_consulta(newBus.getName_consulta());
	                    return repository.save(bus);
	                })
	                .orElseGet(() -> {
	                    newvendedores.setId(id);
	                    return repository.save(newvendedores);
	                });
	    }

	//////////////////////////vendedorsss por vendedores
	    @PutMapping("/vendedores/{id}")
	    ResponseEntity<?> replacevendedor(@RequestBody vendedoress newvendedor, @PathVariable Long id) throws URISyntaxException {

	        vendedores updatedEmployee = repository.findById(id)
	                .map(vendedor -> {
	                    vendedor.setName_consulta(newvendedor.getName_consulta());
	                    return repository.save(vendedor);
	                })
	                .orElseGet(() -> {
	                    newvendedor.setId(id);
	                    return repository.save(new vendedor);
	                });

	        Resource vendedores> resource = assembler.toResource(updatedEmployee);

	        return ResponseEntity
	                .created(new URI(resource.getId().expand().getHref()))
	                .body(resource);
	    }




	    @DeleteMapping("/buses/{id}")
	    void deleteBusess(@PathVariable Long id) {
	        repository.deleteById(id);
	    }

	    //////////////// buses por busees
	    @DeleteMapping("/busees/{id}")
	    ResponseEntity<?> deleteBuses (@PathVariable Long id) {

	        repository.deleteById(id);

	        return ResponseEntity.noContent().build();
	    }

	    //mas

	    //////////////// buses por busees
	    @GetMapping("/vendedores/{id}")
	    Resource<vendedores> one(@PathVariable Long id) {

	        vendedores vendedor = repository.findById(id)
	                .orElseThrow(() -> new BusNotFoundException(id));

	        Resource<vendedores> vendedores = new Resource<>(bus,
	                linkTo(methodOn(vendedores_Controlador.class).one(id)).withSelfRel(),
	               linkTo(methodOn(vendedores_Controlador.class).all()).withRel("vendedores"));
	        return vendedores;
	    }

	    @GetMapping("/vendedores")
	    Resources<Resource<vendedores>> all() {

	        List<Resource<vendedores>> buses = repository.findAll().stream()
	                .map(assembler::toResource)
	                .collect(Collectors.toList());

	        Resources<Resource<vendedores>> resources = new Resources<>(vendedores,
	                linkTo(methodOn(vendedores_Controlador.class).all()).withSelfRel());
	        return resources;
	    }


}
