public class Conversor {
    //Valores ficticios de conversão.
    double[] real = {1.0, 0.20, 0.19, 0.16};  // Real para Dólar, Euro, Libra
    double[] dolar = {5.10, 1.0, 0.95, 0.76}; // Dólar para Real, Euro, Libra
    double[] euro = {5.25, 1.05, 1.0, 0.80};  // Euro para Real, Dólar, Libra
    double[] libra = {6.00, 1.32, 1.25, 1.0}; // Libra para Real, Dólar, Euro




    public double converter(double valor, Moeda origem, Moeda destino) {
        double [] multiplicador;
        switch (origem) {
            case REAL:
                multiplicador = real;
                break;
            case DOLAR:
                multiplicador = dolar;
                break;
            case EURO:
                multiplicador = euro;
                break;
            case LIBRA:
                multiplicador = libra;
                break;
            default:
                throw new IllegalArgumentException("MOEDA NAO ENCONTRADA");
        }

        int indiceDestino = destino.ordinal();

        return valor * multiplicador[indiceDestino];
    }

}
