package com.kodilla.good.patterns.challenges.productorder.challenge;

public class ProductOrderService {

    public double calculateTotalPrice(OrderItem order) {
        return order.getItem().getPrice() + order.getDelivery().deliveryPrice();
    }

    public boolean service(OrderItem order){
        return false;
    }

    //TODO zaleznosc do InformationService ktory symuluje wyslanie maila
    //TODO zależność do repozytorium zmieniajaca zawartosc
    //TODO metoda przyjmujaca OrderRequest z danymi zamowienia, wywola metode z ProductRepository sprawdzi czy produkty sa dostepne
    //TOTO policzy wartosc zamowienia i wywoła metode z wysyłka maila z informacja o zamowieniu
    //TODO zapisac dane zamowienia do repozytorium, zwrocic dane zamowienia
    //obiekty odpowiedzialne za logike moga miec metody pracujace na obiektach ale same nie moga zalezec od tych obiektow

    public boolean isOrdered() {
//        if (inventory.isAvaliable(item)) {
//            return true;
//        } else {
//            return false;
//        }
        return false;
    }


}
