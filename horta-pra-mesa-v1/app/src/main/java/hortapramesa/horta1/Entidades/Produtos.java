package hortapramesa.horta1.Entidades;

/**
 * Created by leandro on 06/09/2017.
 */

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

import hortapramesa.horta1.DAO.ConfiguracaoFirebase;



public class Produtos {


    private String nome;
    private Double valor;


    public Produtos() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
