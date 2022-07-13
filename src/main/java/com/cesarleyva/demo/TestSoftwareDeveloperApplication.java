package com.cesarleyva.demo;


import com.cesarleyva.demo.models.Factura;
import com.cesarleyva.demo.models.Persona;
import com.cesarleyva.demo.repositories.FacturaRepository;
import com.cesarleyva.demo.repositories.PersonaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.cesarleyva.demo"})
@EntityScan("com.cesarleyva.demo.models")
@EnableJpaRepositories("com.cesarleyva.demo.repositories")
public class TestSoftwareDeveloperApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSoftwareDeveloperApplication.class, args);
	}

	// utilizamops command line runner para cargar datos en la base de datos
	@Bean
	public CommandLineRunner setup(PersonaRepository personaRepository, FacturaRepository facturaRepository) {
		return (args) -> {
			//creamos objetos persona para su insercion en la base de datos
			Persona persona1 = new Persona(1, "Cesar", "Leyva", "Luna", "11111");
			Persona persona2 = new Persona(2, "Juan", "Perez", "Perez", "22222");
			Persona persona3 = new Persona(3, "Pedro", "Perez", "Perez", "33333");
			Persona persona4 = new Persona(4, "Maria", "Perez", "Perez", "44444");
			Persona persona5 = new Persona(5, "Juan", "Perez", "Perez", "55555");
			//agregamos usuarios de ejemplo
			personaRepository.save(persona1);
			personaRepository.save(persona2);
			personaRepository.save(persona3);
			personaRepository.save(persona4);
			personaRepository.save(persona5);
			//agregamos facturas de ejemplo
			facturaRepository.save(new Factura(1,"12-07-2022",200.0,persona1.getIdentificacion()));
			facturaRepository.save(new Factura(2,"03-07-2022",300.0,persona2.getIdentificacion()));
			facturaRepository.save(new Factura(3,"04-07-2022",400.0,persona3.getIdentificacion()));
			facturaRepository.save(new Factura(4,"05-07-2022",200.0,persona4.getIdentificacion()));
			facturaRepository.save(new Factura(5,"06-07-2022",300.0,persona5.getIdentificacion()));
			facturaRepository.save(new Factura(7,"13-07-2022",200.0,persona1.getIdentificacion()));
			facturaRepository.save(new Factura(8,"04-07-2022",300.0,persona2.getIdentificacion()));
			facturaRepository.save(new Factura(9,"05-07-2022",400.0,persona3.getIdentificacion()));
			facturaRepository.save(new Factura(10,"25-07-2022",200.0,persona4.getIdentificacion()));
			facturaRepository.save(new Factura(11,"16-07-2022",300.0,persona5.getIdentificacion()));


		};
	}





}
