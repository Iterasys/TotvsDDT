import com.totvs.Calculadora;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteCalculadora {

    @ParameterizedTest
    @CsvSource(value = {
            "5, 7, 12",
            "-8, 10, 2",
            "7, 0, 7",
            "3.33,6.67,10"
    }, delimiter = ',')
    public void testeSomar(double num1, double num2, double resultadoEsperado){
        // Configura
        // a partir das lista de dados fornecida acima
        // Executa
        double resultadoAtual = Calculadora.somar(num1, num2);
        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "5, 7, -2",
            "-8, 10, -18",
            "7, 0, 7",
            "3.33,6.67,-3.34",
            "25,3,22"
    }, delimiter = ',')
    public void testeSubtrair(double num1, double num2, double resultadoEsperado){
        // Configura
        // a partir das lista de dados fornecida acima
        // Executa
        double resultadoAtual = Calculadora.subtrair(num1, num2);
        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "5, 2, 2.5",
            "-8, 4, -2",
            "7, 0, Infinity",
            "6.66, 3.33,2"
    }, delimiter = ',')
    public void testeDividir(double num1, double num2, double resultadoEsperado){
        // Configura
        // a partir das lista de dados fornecida acima
        // Executa
        double resultadoAtual = Calculadora.dividir(num1, num2);
        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "5, 2, 10",
            "-8, 4, -32",
            "7, 0, 0",
            "1.5, 2, 3"
    }, delimiter = ',')
    public void testeMultiplicar(double num1, double num2, double resultadoEsperado){
        // Configura
        // a partir das lista de dados fornecida acima
        // Executa
        double resultadoAtual = Calculadora.multiplicar(num1, num2);
        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    }
}
