import java.util.Scanner;

public class Calculos {
    private String monedaBase;
    private String monedaObjetivo;
    private double cantidad;

    Scanner lectura = new Scanner(System.in);
    ConsultaConversion conversion;

    public Calculos(ConsultaConversion conversion) {
        this.conversion = conversion;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void almacenarValores(String monedaBase, String monedaObjetivo){
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;

        System.out.println("Ingrese el valor que deseas convertir");

        this.cantidad = Double.parseDouble(lectura.nextLine());
    }

    public void almacenarValoresPersonalizados(){
        String menuOtrasOpciones = """
                Currency Code       Currency Name       Country
                AED UAE Dirham                          United Arab Emirates
                ARS	Argentine Peso	                    Argentina
                BRL	Brazilian Real	                    Brazil
                CLP	Chilean Peso	                    Chile
                CNY	Chinese Renminbi	                China
                GBP	Pound Sterling	                    United Kingdom
                INR	Indian Rupee	                    India
                KRW	South Korean Won	                South Korea
                NZD	New Zealand Dollar	                New Zealand
                PKR	Pakistani Rupee	                    Pakistan
                ZAR	South African Rand	                South Africa
                """;
                
        System.out.println(menuOtrasOpciones);
        System.out.println("Escribe la clave de 3 digitos que ingresa: ");
        this.monedaBase = lectura.next();
        System.out.println("Escribe la clave de 3 digitos de la moneda a convertir: ");
        this.monedaObjetivo = lectura.next();

        boolean entradaValida = false;
        do {
            System.out.println("Ingresa el monto a convertir: ");
            if (lectura.hasNextDouble()) {
                this.cantidad = lectura.nextDouble();
                entradaValida = true;
            } else {
                System.out.println("Ocurrior un error, deben ser valores numericos.");
                lectura.next();
            }
        } while (!entradaValida);
    }

    public String obtenerMensajeRespuesta() {
        String mensaje = getMonedaBase().toUpperCase() + " " + getCantidad() + " equivale a: " + getMonedaObjetivo().toUpperCase() + " " + conversion.buscaConversion(getMonedaBase(), getMonedaObjetivo(), getCantidad());
        System.out.println(mensaje);
        return mensaje;
    }
}
