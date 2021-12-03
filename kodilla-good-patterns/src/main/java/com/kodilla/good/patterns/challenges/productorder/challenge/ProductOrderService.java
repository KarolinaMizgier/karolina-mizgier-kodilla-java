package com.kodilla.good.patterns.challenges.productorder.challenge;

public class ProductOrderService {
    private Product product;
    private User user;
    private ProductInventory inventory;
    private UserNotification notification;

    public ProductOrderService(Product product, User user, ProductInventory inventory) {
        this.product = product;
        this.user = user;
        this.inventory = inventory;
    }

    public double calculateTotalPrice(Order order) {

        return order.getProduct(). + delivery.deliverBy();
    }

    //TODO zaleznosc do InformationService ktory symuluje wyslanie maila
    //TODO zależność do repozytorium zmieniajaca zawartosc
    //TODO metoda przyjmujaca OrderRequest z danymi zamowienia, wywola metode z ProductRepository sprawdzi czy produkty sa dostepne
    //TOTO policzy wartosc zamowienia i wywoła metode z wysyłka maila z informacja o zamowieniu
    //TODO zapisac dane zamowienia do repozytorium, zwrocic dane zamowienia
    //obiekty odpowiedzialne za logike moga miec metody pracujace na obiektach ale same nie moga zalezec od tych obiektow

    public void pocessOrder(Product product, User user, ProductInventory inventory){

    }
    public boolean isOrdered() {
        if (inventory.isAvaliable(product)) {
            return true;
        } else {
            return false;
        }
    }


}
