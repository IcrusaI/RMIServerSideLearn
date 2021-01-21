import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class App {
    public static final String UNIC_BINDING_NAME = "server.bookcase.validator";

    public static void main(String[] args) throws Exception
    {
        //создание объекта для удаленного доступа
        final BookcaseValidatorImpl service = new BookcaseValidatorImpl();

        //создание реестра расшареных объетов
        final Registry registry = LocateRegistry.createRegistry(2099);
        //создание "заглушки" – приемника удаленных вызовов
        Remote stub = UnicastRemoteObject.exportObject(service, 0);
        //регистрация "заглушки" в реесте
        registry.bind(UNIC_BINDING_NAME, stub);

        //усыпляем главный поток, иначе программа завершится
        Thread.sleep(Integer.MAX_VALUE);
    }
}
