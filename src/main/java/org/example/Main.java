package org.example;

import org.example.business.ProductManager;
import org.example.core.logging.DatabaseLogger;
import org.example.core.logging.FileLogger;
import org.example.core.logging.Logger;
import org.example.dataAccess.HibernateProductDao;
import org.example.dataAccess.JdbcProductDao;
import org.example.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Product product1 = new Product(1, "Iphone X", 25000);
        List<Logger> loggers = new ArrayList<Logger>();
        loggers.add(new DatabaseLogger());
        loggers.add(new FileLogger());

        ProductManager productManager = new ProductManager(new HibernateProductDao(), loggers);
        productManager.add(product1);
    }
}