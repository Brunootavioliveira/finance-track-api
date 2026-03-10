package br.com.brunootavio.finance_track.service;

import br.com.brunootavio.finance_track.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(User user) {

        return Jwts.builder() //vou contruir um token jwt
                .setSubject(user.getEmail()) //dono do token, email do usuario "sub"
                .setIssuedAt(new Date()) //data que token foi criado "iat"
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) //quando vai expirar
                .signWith(SignatureAlgorithm.HS256, secret) //confirmar se ninguem alterou o token
                .compact(); // tranforma tudo em string "HEADER.PAYLOAD.SIGNATURE"
    }

    public String extractEmail(String token) {

        return  Jwts.parser()// vou ler esse token
                .setSigningKey(secret)//chave secreta usada para validar o token
                .parseClaimsJws(token)//verifica assinatura, expiração formato
                .getBody() //pega payload do token "ju@gmail.com"
                .getSubject(); // pegar email do usuario colocado
    }
}
