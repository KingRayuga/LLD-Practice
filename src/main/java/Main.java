import Bridge.*;
import Composite.Directory;
import Composite.File;
import Composite.FileSystemComponent;


public class Main {
    public static void main(String[] args){
        FileSystemComponent file1 = new File("Document.txt");
        FileSystemComponent file2 = new File("Image.jpg");
        FileSystemComponent file3 = new File("Spreadsheet.xlsx");

        Directory rootDirectory = new Directory("Root");
        Directory documentsDirectory = new Directory("Documents");
        Directory imagesDirectory = new Directory("Images");

        documentsDirectory.addComponent(file1);
        documentsDirectory.addComponent(file3);
        imagesDirectory.addComponent(file2);

        rootDirectory.addComponent(documentsDirectory);
        rootDirectory.addComponent(imagesDirectory);

        rootDirectory.showDetails();
    }
}
