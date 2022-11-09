package ua.lb4.restclient;

import jakarta.ws.rs.client.*;
import ua.lb4.restclient.model.driver.Car;
import ua.lb4.restclient.model.driver.Driver;
import ua.lb4.restclient.model.order.Order;
import ua.lb4.restclient.model.user.EmailOrPhone;
import ua.lb4.restclient.model.user.User;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Logger;

public class Start {

    private static Logger LOG = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();

        Driver driver = new Driver();
        driver.setAge(28);
        driver.setMark(BigDecimal.valueOf(8.94));
        driver.setId(2);
        driver.setCode("WQWQE");
        driver.setName("Дмитро");
        driver.setSurname("Дмитречук");
        driver.setPhone("+380990166700");

        Car car = new Car();
        driver.setCar(car);
        car.setBrand("Skoda");
        car.setId(2);
        car.setCode("SDFDF");
        car.setCClass("Середній");
        car.setColor("Сірий");
        car.setName("Fabia");
        car.setNumber("AX7635HI");
        car.setVinNumber("DSFSD438F3SDFSDFD");
        car.setYearOfProduction(2012);

        EmailOrPhone emailOrPhone = new EmailOrPhone();
        emailOrPhone.setEmail("petro@gmail.com");

        User user = new User();
        user.setName("Петро");
        user.setSurname("Пилипенко");
        user.setId(2);
        user.setCode("SADAW");
        user.setAddressFrom("Станція метро Спортивна");
        user.setAddressTo("вулиця Научна 33");
        user.setAnswer(emailOrPhone);


        Order order = new Order();
        order.setId(1);
        order.setCode("RWAER");
        order.setDriver(driver);
        order.setUser(user);
        order.setPrice(BigDecimal.valueOf(109.94));
        order.setMark(7);


        boolean stop = false;
        while (!stop) {
            System.out.println("Оберіть дію");
            System.out.println("1.\tСтворити замовлення");
            System.out.println("2.\tПоказати усі замовлення");
            System.out.println("3.\tЗнайти водія по коду");
            System.out.println("4.\tЗнайти водія по прізвищу");
            System.out.println("5.\tПоказати усі замовлення, де оцінка вище за надану");
            System.out.println("6.\tПоказати усі замовлення, де оцінка нижче за надану");
            int n = new Scanner(System.in).nextInt();
            switch (n) {
                case 1:
                    System.out.println("Створено замовлення:\n"+ClientOperations.createOrder(order,client));
                    break;
                case 2:
                    try {
                        System.out.print("Уведіть id користувача: ");
                        int id = new Scanner(System.in).nextInt();
                        System.out.println("Отримано замовлення:\n"+ClientOperations.getOrders(id,client));
                    } catch (InputDataException e) {
                        LOG.warning(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Уведіть код водія: ");
                        String code = new Scanner(System.in).next();
                        System.out.println("Отримано водія:\n"+ClientOperations.getDriverByCode(code,client));
                    } catch (InputDataException e) {
                        LOG.warning(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Уведіть прізвище водія: ");
                        String name = new Scanner(System.in).next();
                        System.out.println("Отримано водія:\n"+ClientOperations.getDriversBySurname(name,client));
                    } catch (InputDataException e) {
                        LOG.warning(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Уведіть оцінку: ");
                        int mark = new Scanner(System.in).nextInt();
                        System.out.println("Отримано замовлення:\n"+ClientOperations.getHistoryAboveMark(mark,client));
                    } catch (InputDataException e) {
                        LOG.warning(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.print("Уведіть оцінку: ");
                        int mark = new Scanner(System.in).nextInt();
                        System.out.println("Отримано замовлення:\n"+ClientOperations.getHistoryBelowMark(mark,client));
                    } catch (InputDataException e) {
                        LOG.warning(e.getMessage());
                    }
                    break;
                default:
                    LOG.warning("Надано невірне значення");
            }
            System.out.println("\nНатисніть ENTER, що б продовжити, або будь-який символ, що б вийти");
            if (!new Scanner(System.in).nextLine().isBlank())
                stop = true;
        }
    }
}
