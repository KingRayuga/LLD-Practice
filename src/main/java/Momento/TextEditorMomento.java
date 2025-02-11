package Momento;

class TextEditorMomento {
    private String text;

    TextEditorMomento(String text){
        this.text = text;
    }

    public void saveText(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
