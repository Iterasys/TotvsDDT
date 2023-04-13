import com.totvs.Frete;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TesteFrete {

    @Test
    public void testeCalcularFreteSimples() {
        // Configura
        double distancia = 30;
        double peso = 2;
        int volume = 2;
        double precoEsperado = 45;

        // Executa
        double precoAtual = Frete.calcularFrete(distancia, peso, volume);

        // Valida
        assertEquals(precoEsperado, precoAtual);
    }

    // Teste baseado em uma lista de dados
    @ParameterizedTest
    @CsvSource(value = {
            "1,10,0,1,8.00",
            "2,0,1,2,12.00",
            "3,40,2,3,90.00",
            "4,100,5,4,1440.00",
    }, delimiter = ',')
    public void testeCalcularFreteLista(String strTc, String strDistancia, String strPeso, String strVolume, String strPrecoEsperado) {
        // Configura
        double distancia = Double.valueOf(strDistancia);
        double peso = Double.valueOf(strPeso);
        int volume = Integer.valueOf(strVolume);

        // Executa
        Object precoAtual = Frete.calcularFrete(distancia, peso, volume);

        // Valida
        assertEquals(Double.valueOf((String) strPrecoEsperado), precoAtual);

    }

    // Teste das exceções com base em uma lista de dados
    @ParameterizedTest
    @CsvSource(value = {
            "5,101,10,1,'Distância muito longa, não é possível calcular o frete.'",
            "6,40,11,5,'Peso muito grande, não é possível calcular o frete.'"
    }, delimiter = ',')
    public void testeCalcularFreteListaInvalidos(String strTc, String strDistancia, String strPeso, String strVolume, String strPrecoEsperado) {
        // Configura
        double distancia = Double.valueOf(strDistancia);
        double peso = Double.valueOf(strPeso);
        int volume = Integer.valueOf(strVolume);

        // Executa
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Frete.calcularFrete(distancia, peso, volume);
        });

        // Valida
        assertEquals(strPrecoEsperado, exception.getMessage());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaFrete.csv", numLinesToSkip = 0, delimiter = ',')
    public void testeCalcularFreteArquivo(String strTc, String strDistancia, String strPeso, String strVolume, String strPrecoEsperado){
        // Configura
        double distancia = Double.valueOf(strDistancia);
        double peso = Double.valueOf(strPeso);
        int volume = Integer.valueOf(strVolume);

        // Executa
        Object precoAtual = Frete.calcularFrete(distancia, peso, volume);

        // Valida
        assertEquals(Double.valueOf((String) strPrecoEsperado), precoAtual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaFreteInvalidos.csv", numLinesToSkip = 0, delimiter = ',')
    public void testeCalcularFreteArquivoInvalidos(String strTc, String strDistancia, String strPeso, String strVolume, String strPrecoEsperado) {
        // Configura
        double distancia = Double.valueOf(strDistancia);
        double peso = Double.valueOf(strPeso);
        int volume = Integer.valueOf(strVolume);

        // Executa
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Frete.calcularFrete(distancia, peso, volume);
        });

        // Valida
        assertEquals(strPrecoEsperado, exception.getMessage());

    }

}