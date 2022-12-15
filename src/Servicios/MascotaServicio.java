package Servicios;

import Entidades.Mascota;

import java.util.*;

public class MascotaServicio {
    ArrayList<String> mascotas = new ArrayList<>();
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    Mascota m1 = new Mascota();

    public void crearMascota() {
        String resp;
        boolean salir = false;

        System.out.println("Ingresa la raza");
        m1.setRaza(sc.next());
        m1.setRaza(m1.getRaza().substring(0, 1).toUpperCase() + m1.getRaza().substring(1).toLowerCase());
        mascotas.add(m1.getRaza());

        do {
            System.out.println("Deseas ingresar más razas? S/N");
            resp = sc.next();
            while (!resp.equalsIgnoreCase("s") && !resp.equalsIgnoreCase("n")) {
                System.out.println("Respuesta inválida");
                System.out.println("Deseas ingresar más razas? S/N");
                resp = sc.next();
            }
            if (resp.equalsIgnoreCase("s")) {
                System.out.println("Ingresa la raza");
                m1.setRaza(sc.next());
                m1.setRaza(m1.getRaza().substring(0, 1).toUpperCase() + m1.getRaza().substring(1).toLowerCase());
                if (mascotas.contains(m1.getRaza())) {
                    System.out.println("La raza ingresada ya había sido ingresada");
                } else {
                    mascotas.add(m1.getRaza());
                }
            } else {
                salir = true;
            }

        } while (!salir);

        Collections.sort(mascotas);

        System.out.println("Las mascotas creadas son ");
        for (String s : mascotas) {
            System.out.println(s);
        }


        eliminarMascota();

        System.out.println("Las razas de mascotas sin las que eliminaste son ");
        for (String s : mascotas) {
            System.out.println(s);
        }

    }

    public void eliminarMascota() {
        String razaIngresada;
        boolean salir = false;
        Iterator<String> iter = mascotas.iterator();
        String mascotasEnArray = iter.next();

        System.out.println("Ingresa la raza del perro que quieres eliminar");
        razaIngresada = sc.next();
        razaIngresada = razaIngresada.substring(0, 1).toUpperCase() + razaIngresada.substring(1).toLowerCase();

        if (mascotas.contains(razaIngresada)) {
            mascotas.remove(razaIngresada);
        } else {
            System.out.println("No se encontró la raza que ingresaste");
        }
        do {
            System.out.println("Deseas eliminar otra raza? S/N");
            String resp = sc.next();
            while (!resp.equalsIgnoreCase("s") && !resp.equalsIgnoreCase("n")) {
                System.out.println("Respuesta Incorrecta");
                System.out.println("Deseas eliminar otra raza? S/N");
                resp = sc.next();
            }
            if (resp.equalsIgnoreCase("s")) {
                System.out.println("Ingresa la raza del perro que quieres eliminar");
                razaIngresada = sc.next();
                razaIngresada = razaIngresada.substring(0, 1).toUpperCase() + razaIngresada.substring(1).toLowerCase();
                if (mascotas.contains(razaIngresada)) {
                    mascotas.remove(razaIngresada);
                } else {
                    System.out.println("No se encontró la raza que ingresaste");
                }
            } else {

                salir = true;
            }
        } while (!salir);

    }


}
