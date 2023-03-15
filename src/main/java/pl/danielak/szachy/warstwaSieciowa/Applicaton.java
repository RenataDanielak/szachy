package pl.danielak.szachy.warstwaSieciowa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "pl.danielak")
public class Applicaton {

    public static void main(String[] args) {
        SpringApplication.run(Applicaton.class, args);
    }
}
