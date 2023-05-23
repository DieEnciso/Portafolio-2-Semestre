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
            System.out.println("----------- MENÚ -----------");
            System.out.println("1. Registrar denuncia");
            System.out.println("2. Ver denuncias");
            System.out.println("3. Salir");
            System.out.println("-----------------------------");
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
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static void registrarDenuncia() {
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
        if (denuncias.isEmpty()) {
            System.out.println("No se han registrado denuncias.");
            return;
        }

        System.out.println("----- LISTA DE DENUNCIAS -----");

        for (int i = 0; i < denuncias.size(); i++) {
            Denuncia denuncia = denuncias.get(i);

            System.out.println("Denuncia " + (i + 1) + ":");
            System.out.println("Denunciante: " + denuncia.getDenunciante());
            System.out.println("Deudor: " + denuncia.getDeudor());
            System.out.println("Motivo: " + denuncia.getMotivo());
            System.out.println("--------------------------------");
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
