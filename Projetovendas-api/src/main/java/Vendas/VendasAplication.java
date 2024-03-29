package Vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasAplication {
	
	@GetMapping("/hello/{nome}")
	public String hello(@PathVariable String nome) {
		return "Olá Mundo!!: "+nome;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasAplication.class, args);
	}

}
