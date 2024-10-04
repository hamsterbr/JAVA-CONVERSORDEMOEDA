import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        Conversor conversor = new Conversor();

        String plural = "";

        System.out.println("MENU DE MOEDAS:");
        System.out.println("0 ---> REAL");
        System.out.println("1 ---> DOLAR");
        System.out.println("2 ---> EURO");
        System.out.println("3 ---> LIBRA\n");

        System.out.println("DIGITE QUAL VALOR:");
        double valorDigitado = x.nextDouble();
        System.out.println("QUAL NUMERO DO MENU A MOEDA PERTENCE?");
        int moedaOrigem = x.nextInt();
        while (moedaOrigem < 0 || moedaOrigem > 3){
            System.out.println("MOEDA NAO CADASTRADA, ESCOLHA UMA DAS OPCOES DO MENU:");
            moedaOrigem = x.nextInt();
        }
        Moeda moeda = Moeda.values()[moedaOrigem];

        Dinheiro dinheiro = new Dinheiro(valorDigitado, moeda);
        double valor = dinheiro.getValor();
        Moeda origem = dinheiro.getMoeda();

        if(valor > 1) {
            switch (origem.name()) {
                case "REAL":
                    plural = "REAIS";
                    break;
                case "DOLAR":
                    plural = "DOLARES";
                    break;
                case "EURO":
                    plural = "EUROS";
                    break;
                case "LIBRA":
                    plural = "LIBRAS";
                    break;
            }
            System.out.println("VOCE DESEJA CONVERTER " + valor + " " + plural + " PARA QUAL MODEDA (SELECIONE UTILIZANDO O NUMERO DO MENU RELACIONADO)?");
        }else {
            System.out.println("VOCE DESEJA CONVERTER  " + valor + " " + dinheiro.getMoeda().name() + " PARA QUAL MODEDA (SELECIONE UTILIZANDO O NUMERO DO MENU RELACIONADO)?");
        }

        int destinoMoeda = x.nextInt();
        while (destinoMoeda < 0 || destinoMoeda > 3 ){
            System.out.println("MOEDA NAO CADASTRADA, ESCOLHA UMA DAS OPCOES DO MENU:");
            destinoMoeda = x.nextInt();
        }
        Moeda destino = Moeda.values()[destinoMoeda];

        double resultado = conversor.converter(valor, origem, destino);

        if(valor > 1) {
            switch (destino.name()) {
                case "REAL":
                    plural = "REAIS";
                    break;
                case "DOLAR":
                    plural = "DOLARES";
                    break;
                case "EURO":
                    plural = "EUROS";
                    break;
                case "LIBRA":
                    plural = "LIBRAS";
                    break;
            }
            System.out.printf("RESULTADO: %.2f %s\n", resultado, plural);
        }else {
            System.out.printf("RESULTADO: %.2f %s\n", resultado, destino);
        }

    }
}
