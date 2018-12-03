package model;

public abstract class Vegetable implements Growable {

    private String name;
    private VegType type;
    private String instruction;

    public Vegetable(String name, VegType type) {
        this.name = name;
        this.type = type;
        setInstructions("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VegType getType() {
        return type;
    }

    protected void setInstructions(String instructions){
        this.instruction = instructions;
    }

    @Override
    public String getInstruction() {
        return this.instruction;
    }
}

