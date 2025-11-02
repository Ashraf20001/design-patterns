package org.dp.behavioural;

public class MementoExample {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(new TextWindow());
        textEditor.write("This is ashraf");
        textEditor.write("Implementing memento");
        System.out.println("Before saving state");
        textEditor.displayTextWindow();
        textEditor.doSave();
        System.out.println("After saving state");
        textEditor.displayTextWindow();
        textEditor.write("hello");
        System.out.println("After writing hello");
        textEditor.displayTextWindow();
        textEditor.restoreState();
        System.out.println("After restore state");
        textEditor.displayTextWindow();
    }
}

// Care taker
class TextEditor{
    private TextState textState; // This is responsible for saving and restoring state
    private final TextWindow textWindow;
    public TextEditor(TextWindow textWindow){
        this.textWindow = textWindow;
    }

    public void write(String text){
        this.textWindow.addText(text);
    }

    public void doSave(){
       textState = textWindow.saveTextState();
    }

    public void restoreState(){
        this.textWindow.restoreState(textState);
    }

    public void displayTextWindow(){
        textWindow.displayString();
    }

}

// Originator
class TextWindow{
    private StringBuilder stringBuilder;

    public TextWindow(){
        this.stringBuilder = new StringBuilder();
    }

    public void addText(String text){
        this.stringBuilder.append(text);
    }

    // save state
    public TextState saveTextState(){
        return new TextState(stringBuilder.toString());
    }

    // restore state
    public void restoreState(TextState savedState){
        stringBuilder = new StringBuilder(savedState.getState());
    }

    public void displayString(){
        System.out.println(this.stringBuilder.toString());
    }

}

// Memento
class TextState{
    private final String state;

    public TextState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}

/*
        Memento acts as a state manager. We can add state to the memento at any point of time and restore it when needed.
 */

