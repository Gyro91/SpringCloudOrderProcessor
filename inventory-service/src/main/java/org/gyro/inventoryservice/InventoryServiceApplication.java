package org.gyro.inventoryservice;

import org.gyro.inventoryservice.model.Inventory;
import org.gyro.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory obj1 = new Inventory();
            obj1.setSkuCode("iphone1");
            obj1.setQuantity(100);

            Inventory obj2 = new Inventory();
            obj2.setSkuCode("iphone1");
            obj2.setQuantity(100);

            inventoryRepository.save(obj1);
            inventoryRepository.save(obj2);
            };
    }

}
