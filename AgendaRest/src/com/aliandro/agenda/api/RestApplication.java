package com.aliandro.agenda.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApplication extends Application {
/*
 * Estamos estendendo a classe Application para herdar as características mínimas para
 * que a nossa aplicação seja REST, através do JAX-RS.
 * 
 * Estaos anotando a aplicação como @ApplicationPath pra definir o caminho que vai ser
 * considerado para ativar as APIs REST.
 * 
 * Dessa forma, uma vez que definimos "/api", nossa API REST será chamada em:
 * 
 *  http://localhost:8080/AgendaRest/apis/<minha_api_rest>, onde:
 *  
 *  - http://localhost:8080/ é a localização para acesso ao meu servidor JBoss;
 *  - AgendaRest/ é o context-root (contexto web) para este projeto web, que por 
 *  padrão é o próprio nome do projeto;
 *  - apis/ é o pattern para ativar as APIs REST.
 * 
 * */
}
