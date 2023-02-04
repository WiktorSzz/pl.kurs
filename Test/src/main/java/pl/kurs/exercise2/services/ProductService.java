package pl.kurs.exercise2.services;

import pl.kurs.exercise2.models.Product;

public class ProductService {
    private final Product[] productArray;
    private int howManyProducts;

    public ProductService(int capacity) {
        this.productArray = new Product[capacity];
    }

    public Product addProducts(Product product) {
        if (product == null) System.out.println("Nie podano produktu do dodania!");
        else if (howManyProducts == productArray.length)
            System.out.println("Tablica jest pełna, nie możesz dodać produktu.");
        else {
            productArray[howManyProducts++] = product;
            System.out.println("Produkt został pomyślnie dodany do magazynu " + product);
        }
        return product;
    }


    public double averageProductsPriceInCategory(String category) {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < howManyProducts; i++) {
            Product product = productArray[i];
            if (product.getCategory().equalsIgnoreCase(category)) {
                sum += product.getPrice();
                count++;
            }
        }
        double averagePrice = sum / count;
        System.out.println("Średnia cena za produkty z kategorii " + category + " wynośi: " + String.format("%.2f", averagePrice));
        return averagePrice;
    }

    public double theMostExpensiveProduct() {
        double maxPrice = Double.MIN_VALUE;
        for (int i = 0; i < howManyProducts; i++) {
            Product product = productArray[i];
            if (product.getPrice() > maxPrice) {
                maxPrice = product.getPrice();
            }
        }
        System.out.println("Najdroższy produkt: " + String.format("%.2f", maxPrice));
        return maxPrice;
    }

    public double theCheapestProduct() {
        double minPrice = Double.MAX_VALUE;
        for (int i = 0; i < howManyProducts; i++) {
            Product product = productArray[i];
            if (product.getPrice() < minPrice) {
                minPrice = product.getPrice();
            }
        }
        System.out.println("Najtańszy produkt: " + String.format("%.2f", minPrice));
        return minPrice;
    }

    public double averagePrice() {
        double sum = 0;
        double counter = 0;
        for (int i = 0; i < howManyProducts; i++) {
            Product product = productArray[i];
            if (howManyProducts > i) {
                sum += product.getPrice();
                counter++;
            }
        }
        double averagePrice = sum / counter;
        System.out.println("Średnia cena wszystkich produktów wynośi: " + String.format("%.2f", averagePrice));
        return averagePrice;
    }

    public double howManyProductsMoreExpensiveThanAverage() {
        double sum = 0;
        double counter = 0;

        for (int i = 0; i < howManyProducts; i++) {
            Product product = productArray[i];
            if (howManyProducts > i) {
                sum += product.getPrice();
                counter++;
            }
        }
        double averagePrice = sum / counter;
        int counter1 = 0;
        for (int i = 0; i < howManyProducts; i++) {
            Product product = productArray[i];
            if (averagePrice < product.getPrice()) {
                counter1++;
            }
        }
        System.out.println("Produktow droższych niz średnia cena wszystkich produktów jest: " + counter1);
        return counter1;
    }
}





