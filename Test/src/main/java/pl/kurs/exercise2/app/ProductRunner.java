package pl.kurs.exercise2.app;

import pl.kurs.exercise2.models.Product;
import pl.kurs.exercise2.services.ProductService;

public class ProductRunner {
    public static void main(String[] args) {
        ProductService productService = new ProductService(123);
        Product product = new Product("Pralka", 2700, "AGD");
        Product product2 = new Product("Lodówka", 1452, "AGD");
        Product product3 = new Product("Czajnik", 10000, "AGD");
        Product product4 = new Product("Piekarnik", 200, "AGD");
        Product product5 = new Product("Owiewki carbon", 10500, "Motoryzacja");//
        Product product6 = new Product("Wydech Tytanowy", 5500, "Motoryzacja");//"Motoryzacja"
        Product product7 = new Product("Wkrętarka", 2800, "Nardzęnia");//"
        Product product8 = new Product("Betoniarka", 1800, "Nardzęnia");//"Nardzęnia"
        Product product9 = new Product("Narty", 4300, "Sport");//"Sport"


        productService.addProducts(product);
        productService.addProducts(product2);
        productService.addProducts(product3);
        productService.addProducts(product4);
        productService.addProducts(product5);
        productService.addProducts(product6);
        productService.addProducts(product7);
        productService.addProducts(product8);
        productService.addProducts(product9);

        productService.averageProductsPriceInCategory("agd");
        productService.theMostExpensiveProduct();
        productService.theCheapestProduct();
        productService.averagePrice();
        productService.howManyProductsMoreExpensiveThanAverage();
    }


}
