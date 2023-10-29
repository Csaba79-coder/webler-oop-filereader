import model.Product;
import util.FileReaderSingleton;
import util.Printer;

public class FileReaderOopApp {

    // originally
    // package name: homogeneous collection of classes -> plural (egynemű elemek)
    // package name: heterogeneous collection of classes -> singular (vegyes elemek)
    // in this project we follow single package name for all packages!

    public static void main(String[] args) {

        Product[] products = FileReaderSingleton.getInstance().readProductsFromFile(FileReaderSingleton.FILE_PATH);
        Printer.print(products);
    }
}
