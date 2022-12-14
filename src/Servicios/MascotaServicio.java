package Servicios;

import Entidades.Mascota;

import java.util.ArrayList;
import java.util.Scanner;

public class MascotaServicio {

    ArrayList<Mascota> mascotas = new ArrayList<>();
    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void crearMascota() {

        System.out.println("Ingresa la raza");
        mascotas.add(new Mascota(sc.next()));
        String resp;
        boolean salir = false;
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
                mascotas.add(new Mascota(sc.next()));
            } else {
                salir = true;
            }

        } while (!salir);

        System.out.println("Las mascotas creadas son ");
        for (Mascota s : mascotas) {
            System.out.println(s);
        }


    }


}
