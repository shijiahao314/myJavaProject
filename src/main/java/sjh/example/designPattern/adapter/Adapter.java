package sjh.example.designPattern.adapter;

public class Adapter implements Translator {
    private Speaker speaker;
    public Adapter(Speaker speaker) {
        this.speaker = speaker;
    }
    @Override
    public byte[] translate() {
        String sentence = speaker.speak();
        return sentence.getBytes();
    }
}
