/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ibama.estelar.dd;

/**
 *
 * @author bribeiro
 */
public class Message {

   private final String className;
   private StringBuffer message;
   private static final String CONSULTAR = " consultar ";
   private static final String GRAVAR = " gravar ";
   private static final String GRAVADO = " gravado ";
   private static final String EXCLUIR = " excluir ";
   private static final String EXCLUIDO = " excluído ";
   private static final String ERRO = " Erro ";
   private static final String AO = " ao ";
   private static final String COM = " com ";
   private static final String SUCESSO = " sucesso ";

   public Message(String className) {
      this.className = className;
      message = new StringBuffer();
   }

   public Message clear() {
      message = new StringBuffer();
      return this;
   }

   public Message registro() {
      message.append(className);
      return this;
   }

   public Message gravado() {
      message.append(GRAVADO);
      return this;
   }

   public Message excluido() {
      message.append(EXCLUIDO);
      return this;
   }

   public Message com() {
      message.append(COM);
      return this;
   }

   public Message sucesso() {
      message.append(SUCESSO);
      return this;
   }

   public Message erro() {
      message.append(ERRO);
      return this;
   }

   public Message ao() {
      message.append(AO);
      return this;
   }

   public Message gravar() {
      message.append(GRAVAR);
      return this;
   }

   public Message consultar() {
      message.append(CONSULTAR);
      return this;
   }

   public Message excluir() {
      message.append(EXCLUIR);
      return this;
   }

   public String get() {
      return message.toString();
   }

}
