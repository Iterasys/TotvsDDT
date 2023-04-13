package com.totvs;

public class Frete {
    public static double calcularFrete(double distancia, double peso, int volume) {
        // Calcular o custo da distância
        double custoDistancia;
        if (distancia <= 10.0) {
            custoDistancia = 8.0;
        } else if (distancia <= 40.0) {
            custoDistancia = 20.0;
        } else if (distancia <= 100.0) {
            custoDistancia = 45.0;
        } else {
            // Distâncias maiores que 100 km não são suportadas
            throw new IllegalArgumentException("Distância muito longa, não é possível calcular o frete.");
        }

        // Calcular o custo do peso
        double custoPeso;
        if (peso <= 1.0) {
            custoPeso = 1.0;
        } else if (peso <= 2.0) {
            custoPeso = 1.5;
        } else if (peso <= 5.0) {
            custoPeso = 4.0;
        } else if (peso <= 10.0) {
            custoPeso = 10.0;
        } else {
            // Pesos maiores que 10 kg não são suportados
            throw new IllegalArgumentException("Peso muito grande, não é possível calcular o frete.");
        }

        // Calcular o custo do volume
        double custoVolume;
        switch (volume) {
            case 1:
                custoVolume = 1.0;
                break;
            case 2:
                custoVolume = 1.5;
                break;
            case 3:
                custoVolume = 3.0;
                break;
            case 4:
                custoVolume = 8.0;
                break;
            default:
                // Tipos de volumes inválidos não são suportados
                throw new IllegalArgumentException("Tipo de volume inválido, não é possível calcular o frete.");
        }

        // Calcular o frete total
        double frete = custoDistancia * custoPeso * custoVolume;

        // Adicionar os custos por distância, peso e volume ao frete total
        // frete += custoDistancia + custoPeso;

        // Retornar o valor do frete calculado
        return frete;
    }
}

