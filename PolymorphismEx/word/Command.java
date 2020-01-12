package PolymorphismEx.word;

public class Command {
    private String text;
    private TextTransform textTransform;

    Command(String text, TextTransform textTransform){
        this.text = text;
        this.textTransform = textTransform;
    }
    public String getText() {
        return this.text;
    }

    TextTransform getTextTransform() {
        return this.textTransform;
    }

}
