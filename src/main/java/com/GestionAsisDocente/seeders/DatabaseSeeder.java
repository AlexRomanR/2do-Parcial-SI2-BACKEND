package com.GestionAsisDocente.seeders;

import com.GestionAsisDocente.entity.Facultades;
import com.GestionAsisDocente.entity.Modulos;
import com.GestionAsisDocente.entity.OurUsers;
import com.GestionAsisDocente.repository.FacultadesRepository;
import com.GestionAsisDocente.repository.ModulosRepository;
import com.GestionAsisDocente.repository.OurUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private FacultadesRepository facultadesRepository;
    @Autowired
    private OurUserRepo ourUserRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModulosRepository modulosRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if the database is empty or has data
        if (facultadesRepository.count() == 0) {
            // Create seed data
            Facultades facultad1 = new Facultades();
            facultad1.setNombre("Facultad de Ingeniería en Ciencias de la Computación");
            facultad1.setDescripcion("Facultad dedicada a la programación y gestión de sistemas");


            Facultades facultad2 = new Facultades();
            facultad2.setNombre("Facultad de Ciencias Empresariales");
            facultad2.setDescripcion("Facultad dedicada a la administración y gestión empresarial");

            // Save seed data
            facultadesRepository.save(facultad1);
            facultadesRepository.save(facultad2);
        }


        if (ourUserRepo.count() == 0) {
            // Create seed data
            OurUsers ourUsers1 = new OurUsers();
            ourUsers1.setEmail("admin@gmail.com");
            ourUsers1.setName("admin");
            ourUsers1.setPassword(passwordEncoder.encode("12345678"));
            ourUsers1.setRole("ADMIN");

            OurUsers ourUsers2 = new OurUsers();
            ourUsers2.setEmail("user@gmail.com");
            ourUsers2.setName("user");
            ourUsers2.setPassword(passwordEncoder.encode("12345678"));
            ourUsers2.setRole("USER");


            ourUserRepo.save(ourUsers1);
            ourUserRepo.save(ourUsers2);
        }




        //Modulos
        if (modulosRepository.count() == 0) {
            // Create seed data
            Modulos modulos1 = new Modulos();
            modulos1.setNumero(256);
            modulos1.setDescripcion("Modulo de la facultad de ciencias empresariales");



            Modulos modulos2 = new Modulos();
            modulos2.setNumero(213);
            modulos2.setDescripcion("Modulo de la facultad de computación");

            // Obtener las facultades
            Facultades facultad1 = facultadesRepository.findById(1)
                    .orElseThrow(() -> new RuntimeException("Facultad not found with id 1"));

            Facultades facultad2 = facultadesRepository.findById(2)
                    .orElseThrow(() -> new RuntimeException("Facultad not found with id 2"));

            // Set the faculty instance to the modules
            modulos1.setFacultad(facultad1);
            modulos2.setFacultad(facultad2);


            // Save seed data
            modulosRepository.save(modulos1);
            modulosRepository.save(modulos2);
        }




    }
}
