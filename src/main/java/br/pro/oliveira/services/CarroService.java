package br.pro.oliveira.services;

import br.pro.oliveira.models.Carro;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CarroService {
    //Listar
    @GET("/carros")
    //TODOS
    Call<List<Carro>> list();

    @POST("/carros")
    Call<Carro> inserir(@Body Carro carro);

    @GET("/carros/{id}")
    Call<Carro> ler(@Path("id") long id);

    @PATCH("/carros/{id}")
    Call<Carro> atualizar(@Path("id") long id, @Body Carro carro);

    @DELETE("/carros/{id}")
    Call<Carro> excluir(@Path("id") long id);


}
