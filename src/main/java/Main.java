import AbstractFactory.*;

public class Main {
    public static void main(String[] args){
        OSFactory osFactory = new OSFactory();

        OS windowsOS = osFactory.getOS(OSType.WINDOWS);
        Button windowsButton = windowsOS.createButton();
        Checkbox windowsCheckbox = windowsOS.createCheckbox();
        windowsButton.render();
        windowsCheckbox.render();

        OS macOS = osFactory.getOS(OSType.MAC);
        Button macButton = macOS.createButton();
        Checkbox macCheckbox = macOS.createCheckbox();
        macButton.render();
        macCheckbox.render();
    }
}
