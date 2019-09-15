package vendedor1;


	import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

	import org.springframework.hateoas.Resource;
	import org.springframework.hateoas.ResourceAssembler;
	import org.springframework.stereotype.Component;

	    @Component
	    class vendedor_Resource {implements ResourceAssembler<vendedores, Resource<vendedores>> {

	        @Override
	        public Resource<vendedores> toResource(vendedores vendedor) {

	            return new Resource<>(bus,
	                    linkTo(methodOn(vendedores_Controlador.class).one(bus.getId())).withSelfRel(),
	                    linkTo(methodOn(vendedores_Controlador.class).all()).withRel("vendedores"));
	        }
	    }

