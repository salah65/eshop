package edu.miu.cs.cs425.eshop;

import edu.miu.cs.cs425.eshop.product.model.Product;
import edu.miu.cs.cs425.eshop.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EshopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
