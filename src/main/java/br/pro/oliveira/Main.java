package br.pro.oliveira;


import br.pro.oliveira.models.Carro;
import br.pro.oliveira.restclient.RestClient;
import br.pro.oliveira.services.CarroService;
import retrofit2.Response;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main
{

    public static Scanner scanner = new Scanner(System.in);
    public static void main( String[] args ){

        try {
            CarroService carroService =  RestClient.getInstance().getCarroService();


            boolean sair = false;

            do {

                System.out.println("===== Menu =====");
                System.out.println("1. Exibir lista de carros");
                System.out.println("2. Exibir um carro");
                System.out.println("3. Inserir carro novo");
                System.out.println("4. Modificar carro");
                System.out.println("5. Excluir carro");
                System.out.println("0. Sair");
                System.out.println("Escolha uma opção: ");
                int opcao = scanner.nextInt();


                switch (opcao) {
                    case 1:
                        ExibirCarros(carroService);
                        break;
                    case 2:
                        ExibirCarroPeloId(carroService);
                        break;
                    case 3:
                        InserirCarro(carroService);
                        break;
                    case 4:
                        AtualizarCarro(carroService);
                        break;

                    case 5:
                        ExcluirCarro(carroService);
                        break;

                    case 0:
                        sair = true;
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (!sair);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static void ExibirCarros(CarroService carroService) throws IOException {
        //Listar carros

       // carroService.list().enqueue(new CallBackCarros());

        Response<List<Carro>> response = carroService.list().execute();

        if (response.isSuccessful()) {
            List<Carro> carros = response.body();
            for (Carro carro : carros) {
                System.out.println(carro);
            }
        } else {
            System.out.println("Erro ao buscar a lista de carros: " + response.message());
        }

    }

    private static void ExibirCarroPeloId(CarroService carroService) throws IOException {
        //Listar carros
        System.out.println("Qual carro deseja exibir?:");
        int id = scanner.nextInt();

       Response <Carro> response = carroService.ler(id).execute();
        System.out.println(response.body());

    }

    private static void InserirCarro(CarroService carroService) throws IOException {

        Carro novoCarro = new Carro("Teste-2",
                "Ferrari",
                "azul");

        Response <Carro> response = carroService.inserir(novoCarro).execute();
        System.out.println(response.body());

    }

    private static void AtualizarCarro(CarroService carroService) throws IOException{

        Carro novoCarro = new Carro();
        novoCarro.setModelo("Teste-3");

        Response <Carro> response = carroService.atualizar(5,novoCarro).execute();
        System.out.println(response.body());

    }


    private static void ExcluirCarro(CarroService carroService) throws IOException{
        System.out.println("Qual item deseja excluir?:");
        int id = scanner.nextInt();

        Response<Carro> response = carroService.excluir(id).execute();
        System.out.println(response.body());
    }

}
