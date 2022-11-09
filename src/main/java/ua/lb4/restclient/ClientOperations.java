package ua.lb4.restclient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import ua.lb4.restclient.model.driver.Driver;
import ua.lb4.restclient.model.order.Order;
import ua.lb4.restclient.model.order.Orders;

import java.util.List;

public interface ClientOperations {

    static Order createOrder(Order order, Client client) {
        WebTarget target = client.target(LINK.URL + "sendOrder");
        return target.request(MediaType.APPLICATION_XML)
                .accept(MediaType.TEXT_PLAIN_TYPE)
                .post(Entity.xml(order), Order.class);
    }

    static Orders getOrders(int id, Client client) throws InputDataException {
        WebTarget target = client.target(LINK.URL + "userHistory/"+id);
        Orders orders = target.request().get().readEntity(Orders.class);
        if (orders.getOrder().isEmpty())
            throw new InputDataException("Інформації не знайдено");
        return orders;
    }

    static List<Driver> getDriversBySurname(String surname, Client client) throws InputDataException {
        WebTarget target = client.target(LINK.URL + "driverBySurname/"+surname);
        List<Driver> drivers = target.request().get().readEntity(new GenericType<>() {});
        if (drivers.isEmpty())
            throw new InputDataException("Інформації не знайдено");
        return drivers;
    }

    static List<Driver> getDriverByCode(String code, Client client) throws InputDataException {
        WebTarget target = client.target(LINK.URL + "driverByCode/"+code);
        List<Driver> drivers = target.request().get().readEntity(new GenericType<>() {});
        if (drivers.isEmpty())
            throw new InputDataException("Інформації не знайдено");
        return drivers;
    }

    static Orders getHistoryAboveMark(int mark, Client client) throws InputDataException {
        if (mark <= 0 || mark >= 10)
            throw new InputDataException("Оцінка має бути від 1 до 9");
        WebTarget target = client.target(LINK.URL + "historyAbove/"+mark);
        Orders orders = target.request().get().readEntity(Orders.class);
        if (orders.getOrder().isEmpty())
            throw new InputDataException("Інформації не знайдено");
        return orders;
    }

    static Orders getHistoryBelowMark(int mark, Client client) throws InputDataException {
        if (mark <= 0 || mark >= 10)
            throw new InputDataException("Оцінка має бути від 1 до 9");
        WebTarget target = client.target(LINK.URL + "historyBelow/"+mark);
        Orders orders = target.request().get().readEntity(Orders.class);
        if (orders.getOrder().isEmpty())
            throw new InputDataException("Інформації не знайдено");
        return orders;
    }

}
