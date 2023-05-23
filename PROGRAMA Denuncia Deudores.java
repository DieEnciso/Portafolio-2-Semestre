import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Denuncia> denuncias = new ArrayList<>();

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("--------------- MENÚ ---------------");
            System.out.println("1. Registrar denuncia");
            System.out.println("2. Ver denuncias");
            System.out.println("3. Buscar denuncia por denunciante");
            System.out.println("4. Borrar denuncia");
            System.out.println("5. Salir");
            System.out.println("------------------------------------");
            System.out.print("Ingrese la opción deseada: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    registrarDenuncia();
                    break;
                case 2:
                    verDenuncias();
                    break;
                case 3:
                    buscarDenunciaPorDenunciante();
                    break;
                case 4:
                    borrarDenuncia();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción es inválida. Intente nuevamente.");
            }
        }
    }

    public static void registrarDenuncia() {
        System.out.println("-------- REGISTRAR DENUNCIA --------");
        System.out.println("Ingrese el nombre del denunciante:");
        String denunciante = scanner.nextLine();

        System.out.println("Ingrese el nombre del deudor:");
        String deudor = scanner.nextLine();

        System.out.println("Ingrese el motivo de la denuncia:");
        String motivo = scanner.nextLine();

        Denuncia denuncia = new Denuncia(denunciante, deudor, motivo);
        denuncias.add(denuncia);

        System.out.println("Denuncia registrada exitosamente.");
    }

    public static void verDenuncias() {
        System.out.println("-------- LISTA DE DENUNCIAS --------");

        if (denuncias.isEmpty()) {
            System.out.println("No se han registrado denuncias.");
        } else {
            for (int i = 0; i < denuncias.size(); i++) {
                Denuncia denuncia = denuncias.get(i);

                System.out.println("Denuncia " + (i + 1) + ":");
                System.out.println("Denunciante: " + denuncia.getDenunciante());
                System.out.println("Deudor: " + denuncia.getDeudor());
                System.out.println("Motivo: " + denuncia.getMotivo());
                System.out.println("------------------------------------");
            }
        }
    }

    public static void buscarDenunciaPorDenunciante() {
        System.out.println("-------- BUSCAR DENUNCIA POR DENUNCIANTE --------");
        System.out.println("Ingrese el nombre del denunciante:");
        String denunciante = scanner.nextLine();

        List<Denuncia> denunciasEncontradas = new ArrayList<>();

        for (Denuncia denuncia : denuncias) {
            if (denuncia.getDenunciante().equalsIgnoreCase(denunciante)) {
                denunciasEncontradas.add(denuncia);
            }
        }

        if (denunciasEncontradas.isEmpty()) {
            System.out.println("No se encontraron denuncias para el denunciante ingresado.");
        }
        else {
            System.out.println("Denuncias encontradas para el denunciante " + denunciante + ":");
            for (Denuncia denuncia : denunciasEncontradas) {
                System.out.println("Denunciante: " + denuncia.getDenunciante());
                System.out.println("Deudor: " + denuncia.getDeudor());
                System.out.println("Motivo: " + denuncia.getMotivo());
                System.out.println("--------------------------------------");
            }
        }
    }

    public static void borrarDenuncia() {
        System.out.println("----- BORRAR DENUNCIA -----");
        System.out.println("Ingrese el número de denuncia que desea borrar:");
        int numeroDenuncia = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        if (numeroDenuncia >= 1 && numeroDenuncia <= denuncias.size()) {
            Denuncia denunciaBorrada = denuncias.remove(numeroDenuncia - 1);
            System.out.println("Denuncia borrada exitosamente:");
            System.out.println("Denunciante: " + denunciaBorrada.getDenunciante());
            System.out.println("Deudor: " + denunciaBorrada.getDeudor());
            System.out.println("Motivo: " + denunciaBorrada.getMotivo());
        } else {
            System.out.println("Número de denuncia inválido. Intente nuevamente.");
        }
    }
}

class Denuncia {
    private String denunciante;
    private String deudor;
    private String motivo;

    public Denuncia(String denunciante, String deudor, String motivo) {
        this.denunciante = denunciante;
        this.deudor = deudor;
        this.motivo = motivo;
    }

    public String getDenunciante() {
        return denunciante;
    }

    public String getDeudor() {
        return deudor;
    }

    public String getMotivo() {
        return motivo;
    }
}
