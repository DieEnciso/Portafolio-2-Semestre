import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<CorruptionComplaint> complaints = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("----------- MENÚ -----------");
            System.out.println("1. Registrar queja");
            System.out.println("2. Ver quejas");
            System.out.println("3. Buscar queja por denunciante");
            System.out.println("4. Borrar queja");
            System.out.println("5. Salir");
            System.out.println("-----------------------------");
            System.out.print("Ingrese la opción deseada: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    registrarQueja();
                    break;
                case 2:
                    verQuejas();
                    break;
                case 3:
                    buscarQuejaPorDenunciante();
                    break;
                case 4:
                    borrarQueja();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static void registrarQueja() {
        System.out.println("----- REGISTRAR QUEJA -----");
        System.out.println("Ingrese el nombre del denunciante:");
        String denunciante = scanner.nextLine();

        System.out.println("Ingrese el nombre del corrupto:");
        String corrupto = scanner.nextLine();

        System.out.println("Ingrese la descripción de la corrupción:");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese la cantidad de dinero involucrada:");
        double cantidad = scanner.nextDouble();

        System.out.println();

        CorruptionComplaint queja = new CorruptionComplaint(denunciante, corrupto, descripcion, cantidad);
        complaints.add(queja);

        System.out.println("Queja registrada exitosamente.");
    }

    public static void verQuejas() {
        System.out.println("----- LISTA DE QUEJAS -----");

        if (complaints.isEmpty()) {
            System.out.println("No se han registrado quejas.");
        } else {
            for (int i = 0; i < complaints.size(); i++) {
                CorruptionComplaint queja = complaints.get(i);

                System.out.println("Queja " + (i + 1) + ":");
                System.out.println("Denunciante: " + queja.getDenunciante());
                System.out.println("Corrupto: " + queja.getCorrupto());
                System.out.println("Descripción de la corrupción: " + queja.getDescripcion());
                System.out.println("Cantidad de dinero involucrada: " + queja.getCantidad());
                System.out.println("--------------------------------");
            }
        }
    }

    public static void buscarQuejaPorDenunciante() {
        System.out.println("----- BUSCAR QUEJA POR DENUNCIANTE -----");
        System.out.println("Ingrese el nombre del denunciante:");
        String denunciante = scanner.nextLine();

        List<CorruptionComplaint> quejasEncontradas = new ArrayList<>();

        for (CorruptionComplaint queja : complaints) {
            if (queja.getDenunciante().equalsIgnoreCase(denunciante)) {
                quejasEncontradas.add(queja);
}
}
    if (quejasEncontradas.isEmpty()) {
        System.out.println("No se encontraron quejas para el denunciante ingresado.");
    } else {
        System.out.println("Quejas encontradas para el denunciante " + denunciante + ":");
        for (CorruptionComplaint queja : quejasEncontradas) {
            System.out.println("Denunciante: " + queja.getDenunciante());
            System.out.println("Corrupto: " + queja.getCorrupto());
            System.out.println("Descripción de la corrupción: " + queja.getDescripcion());
            System.out.println("Cantidad de dinero involucrada: " + queja.getCantidad());
            System.out.println("--------------------------------");
        }
    }
}

public static void borrarQueja() {
    System.out.println("----- BORRAR QUEJA -----");
    System.out.println("Ingrese el número de queja que desea borrar:");
    int numeroQueja = scanner.nextInt();
    scanner.nextLine(); // Limpiar el buffer de entrada

    if (numeroQueja >= 1 && numeroQueja <= complaints.size()) {
        CorruptionComplaint quejaBorrada = complaints.remove(numeroQueja - 1);
        System.out.println("Queja borrada exitosamente:");
        System.out.println("Denunciante: " + quejaBorrada.getDenunciante());
        System.out.println("Corrupto: " + quejaBorrada.getCorrupto());
        System.out.println("Descripción de la corrupción: " + quejaBorrada.getDescripcion());
        System.out.println("Cantidad de dinero involucrada: " + quejaBorrada.getCantidad());
    } else {
        System.out.println("Número de queja inválido. Intente nuevamente.");
    }
}
}


class CorruptionComplaint {
private String denunciante;
private String corrupto;
private String descripcion;
private double cantidad;
public CorruptionComplaint(String denunciante, String corrupto, String descripcion, double cantidad) {
    this.denunciante = denunciante;
    this.corrupto = corrupto;
    this.descripcion = descripcion;
    this.cantidad = cantidad;
}

public String getDenunciante() {
    return denunciante;
}

public String getCorrupto() {
    return corrupto;
}

public String getDescripcion() {
    return descripcion;
}

public double getCantidad() {
    return cantidad;
}
}
