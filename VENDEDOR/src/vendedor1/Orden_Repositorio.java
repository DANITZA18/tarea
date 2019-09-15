package vendedor1;

	import org.springframework.data.jpa.repository.JpaRepository;

	interface Orden_Repositorio extends JpaRepository<Orden, Long> {
	}
}
