package com.example.loginauthapi.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize

                        //Usuarios


                        //AuthController
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()

                        //machines
                        .requestMatchers(HttpMethod.POST, "/auth/registerMachine").permitAll()
                        .requestMatchers(HttpMethod.GET, "/auth/allMachines").permitAll()


                        //EstoqueInsumosController      hasAnyRole("ControleEstoque", "admin")
                        .requestMatchers(HttpMethod.POST, "/estoque/insumos/adicionar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/estoque/insumos/atualizar/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/estoque/insumos/{id}").permitAll()


                        //EstoquePecasController        .hasAnyRole("EstoquePecas", "admin")
                        .requestMatchers(HttpMethod.POST, "/pecas/add").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/pecas/preco").permitAll()
                        .requestMatchers(HttpMethod.GET, "/pecas/listarPecas").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/pecas/quantidade").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/pecas/deletar").permitAll()


                        //InventarioPecasController     .hasAnyRole("InventarioPecas","admin")
                        .requestMatchers(HttpMethod.POST, "/inventario/add").permitAll()
                        .requestMatchers(HttpMethod.GET, "/inventario/listar").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/inventario/excluir").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/inventario/lugar/alterar").permitAll()
                        .requestMatchers(HttpMethod.GET, "/inventario/{id}").permitAll()


                        //RFIDController         .hasAnyRole("RFID", "admin")
                        .requestMatchers(HttpMethod.POST, "/rfid/create").permitAll()
                        .requestMatchers(HttpMethod.GET, "/rfid/update").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/rfid/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/rfid/all").permitAll()
                        .requestMatchers(HttpMethod.GET, "/rfid/delete/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/localizacao/create").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/localizacao/update").permitAll()
                        .requestMatchers(HttpMethod.GET, "/localizacao/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/localizacao/all").permitAll()
                        .requestMatchers(HttpMethod.GET, "/localizacao/{id}").permitAll()

                        .requestMatchers(HttpMethod.POST, "/usuarios/add").permitAll()
                            


                        //CpfController
                        .requestMatchers(HttpMethod.POST, "/cpf").permitAll()


                        .requestMatchers("/gs-guide-websocket/**").permitAll() // Permitir acesso ao WebSocket endpoint
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}


