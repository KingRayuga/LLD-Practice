package AbstractFactory;

public class Mac implements OS{
    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }

    @Override
    public Button createButton() {
        return new MacButton();
    }
}
