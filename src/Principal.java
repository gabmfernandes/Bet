import Modelos.Baralho;
import java.io.IOException;


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Baralho baralho = new Baralho();

        baralho.criarBaralho();
        baralho.puxarCarta();
        baralho.puxarCarta();


    }
}

