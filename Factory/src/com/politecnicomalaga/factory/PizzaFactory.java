package com.politecnicomalaga.factory;

public class PizzaFactory {
    public static Pizza getTipoPizza(int tipo){
        switch (tipo){
            case Pizza.ESTACIONES:
                return new Pizza4Estaciones();
            case Pizza.MARGARITA:
                return new PizzaMargarita();
            case Pizza.PROSCIUTTO:
                return new PizzaProsciutto();
            case Pizza.VEGANA:
                return new PizzaVegana();
            default:
                throw new IllegalArgumentException("No hay datos de la pizza seleccionada.");
        }
    }
}
