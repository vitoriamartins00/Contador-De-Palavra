package br.edu.fei.contadorpalavras;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author feispvisouza
 */
public class ParDeValores<K, V> {
    private K chave;
    private V value;
    
    public ParDeValores(K chave, V value){
        this.chave = chave;
        this.value = value;
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
    @Override
    public String toString(){
        return this.getChave() + ", " + this.getValue();
    }
}
