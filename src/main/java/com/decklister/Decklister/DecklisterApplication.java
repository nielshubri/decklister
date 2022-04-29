package com.decklister.Decklister;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Deck;
import com.decklister.Decklister.persistence.repository.CardRepository;
import com.decklister.Decklister.persistence.repository.DeckRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class DecklisterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DecklisterApplication.class, args);
	}
}
