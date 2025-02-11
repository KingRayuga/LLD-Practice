package Momento;

import java.util.Stack;

public class TextEditorManager {
    private final TextEditor textEditor = new TextEditor();
    private final Stack<TextEditorMomento> history = new Stack<>();

    public void addText(String text){
        textEditor.writeText(text);
    }

    public void save(){
        history.add(textEditor.saveText());
    }

    public String get(){
        return textEditor.getText();
    }

    public void undo(){
        if(!history.isEmpty()){
            textEditor.restoreText(history.pop());
        }
    }
}
