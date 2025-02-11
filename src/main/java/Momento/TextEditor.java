package Momento;

class TextEditor {
    private String text;

    void writeText(String text){
        this.text += text;
    }

    String getText(){
        return this.text;
    }

    TextEditorMomento saveText(){
        return new TextEditorMomento(this.text);
    }

    void restoreText(TextEditorMomento momento){
        this.text = momento.getText();
    }
}
