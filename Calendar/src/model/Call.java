package model;

public class Call extends Person{

    // Call is associated with outgoing caller
    public Call(String name){
        super(name);
    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public Object getTrace() {
        return null;
    }

    @Override
    public void track() {

    }
}
