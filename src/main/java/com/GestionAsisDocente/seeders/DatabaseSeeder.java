package com.GestionAsisDocente.seeders;

import com.GestionAsisDocente.entity.*;
import com.GestionAsisDocente.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private PermisosRepository permisosRepository;
    @Autowired
    private AulasRepository aulasRepository;
    @Autowired
    private CarrerasRepository carrerasRepository;
    @Autowired
    private MateriasRepository materiasRepository;

    @Override
    public void run(String... args) throws Exception {
        // Facultades
        if (facultadesRepository.count() == 0) {
            Facultades facultad1 = new Facultades();
            facultad1.setNombre("Facultad de Ingeniería en Ciencias de la Computación");
            facultad1.setDescripcion("Facultad dedicada a la programación y gestión de sistemas");

            Facultades facultad2 = new Facultades();
            facultad2.setNombre("Facultad de Ciencias Empresariales");
            facultad2.setDescripcion("Facultad dedicada a la administración y gestión empresarial");

            facultadesRepository.save(facultad1);
            facultadesRepository.save(facultad2);
        }



        // Usuarios
        if (ourUserRepo.count() == 0) {
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

        // Modulos
        if (modulosRepository.count() == 0) {
            Modulos modulos1 = new Modulos();
            modulos1.setNumero(256);
            modulos1.setDescripcion("Modulo de la facultad de ciencias empresariales");
            modulos1.setUbicacion("UbicacionX");

            Modulos modulos2 = new Modulos();
            modulos2.setNumero(213);
            modulos2.setDescripcion("Modulo de la facultad de computación");
            modulos2.setUbicacion("UbicacionX2");

            Facultades facultad1 = facultadesRepository.findById(1)
                    .orElseThrow(() -> new RuntimeException("Facultad not found with id 1"));

            Facultades facultad2 = facultadesRepository.findById(2)
                    .orElseThrow(() -> new RuntimeException("Facultad not found with id 2"));

            modulos1.setFacultad(facultad1);
            modulos2.setFacultad(facultad2);

            modulosRepository.save(modulos1);
            modulosRepository.save(modulos2);
        }

        // Aulas
        if (aulasRepository.count() == 0) {
            Aulas aulas1 = new Aulas();
            aulas1.setCapacidad(65);
            aulas1.setNumero(35);
            aulas1.setPiso(3);
            aulas1.setDescripcion("Aula para avanzar teoria");

            Modulos modulo1 = modulosRepository.findById(1)
                    .orElseThrow(() -> new RuntimeException("Modulo not found with id 1"));

            aulas1.setModulos(modulo1);



            aulasRepository.save(aulas1);

        }

        // carreras
        if (carrerasRepository.count() == 0) {
            Carreras carreras1 = new Carreras();
            carreras1.setCodigo("ING.SIS");
            carreras1.setNombre("Ingenieria en sistemas");

            carrerasRepository.save(carreras1);

        }

        // Materias
        if (materiasRepository.count() == 0) {
            Materias materias1 = new Materias();
            materias1.setSigla("SI2");
            materias1.setNombre("Sistemas de información 2");

            materiasRepository.save(materias1);

        }

        // Permisos
        if (permisosRepository.count() == 0) {
            createPermisos();
        }

        // Roles
        if (rolesRepository.count() == 0) {
            // Obtener todos los permisos ya creados
            List<Permisos> permisos = permisosRepository.findAll();

            // Crear el rol y asignar todos los permisos obtenidos
            Roles rolAdmin = new Roles();
            rolAdmin.setNombre("ADMIN");
            rolAdmin.setPermissions(new ArrayList<>(permisos));

            // Guardar el rol en el repositorio
            rolesRepository.save(rolAdmin);

            // Filtrar los permisos para el rol "USERS"
            List<Permisos> permisosUsuarios = new ArrayList<>();
            for (Permisos permiso : permisosRepository.findAll()) {
                if (permiso.getNombre().startsWith("Listar") &&
                        !permiso.getNombre().equals("Listar Usuarios") &&
                        !permiso.getNombre().equals("Listar Docentes")) {
                    permisosUsuarios.add(permiso);
                }
            }

            // Crear el rol "USERS" y asignar los permisos filtrados
            Roles rolUsers = new Roles();
            rolUsers.setNombre("USERS");
            rolUsers.setPermissions(permisosUsuarios);

            // Guardar el rol "USERS" en el repositorio
            rolesRepository.save(rolUsers);
        }


    }

    private void createPermisos() {
        permisosRepository.save(createPermiso("Listar Usuarios"));
        permisosRepository.save(createPermiso("Editar Usuarios"));
        permisosRepository.save(createPermiso("Eliminar Usuarios"));
        permisosRepository.save(createPermiso("Crear Usuarios"));

        permisosRepository.save(createPermiso("Listar Docentes"));
        permisosRepository.save(createPermiso("Editar Docentes"));
        permisosRepository.save(createPermiso("Eliminar Docentes"));
        permisosRepository.save(createPermiso("Crear Docentes"));

        permisosRepository.save(createPermiso("Listar Materias"));
        permisosRepository.save(createPermiso("Editar Materias"));
        permisosRepository.save(createPermiso("Eliminar Materias"));
        permisosRepository.save(createPermiso("Crear Materias"));

        permisosRepository.save(createPermiso("Listar Carreras"));
        permisosRepository.save(createPermiso("Editar Carreras"));
        permisosRepository.save(createPermiso("Eliminar Carreras"));
        permisosRepository.save(createPermiso("Crear Carreras"));

        permisosRepository.save(createPermiso("Listar Facultades"));
        permisosRepository.save(createPermiso("Editar Facultades"));
        permisosRepository.save(createPermiso("Eliminar Facultades"));
        permisosRepository.save(createPermiso("Crear Facultades"));

        permisosRepository.save(createPermiso("Listar Modulos"));
        permisosRepository.save(createPermiso("Editar Modulos"));
        permisosRepository.save(createPermiso("Eliminar Modulos"));
        permisosRepository.save(createPermiso("Crear Modulos"));

        permisosRepository.save(createPermiso("Listar Aulas"));
        permisosRepository.save(createPermiso("Editar Aulas"));
        permisosRepository.save(createPermiso("Eliminar Aulas"));
        permisosRepository.save(createPermiso("Crear Aulas"));
    }

    private Permisos createPermiso(String nombre) {
        Permisos permiso = new Permisos();
        permiso.setNombre(nombre);
        return permiso;
    }


}

