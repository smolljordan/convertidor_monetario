import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivos {
    public void guardarJson(List<String> lista) {
        try {
            FileWriter fileWriter = new FileWriter("log_consultas.txt");

            for (String resultado : lista) {
                fileWriter.write(resultado);
                fileWriter.write("\n");
            }

            fileWriter.close();
            System.out.println("Log de consultas guardado en 'log_consultas.txt'");

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar el log de consultas: " + e.getMessage());
        }
    }
}