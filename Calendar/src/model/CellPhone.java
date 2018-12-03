package model;

import java.util.List;

public class CellPhone extends Person {
    private List<Call> callhistory;
    private Person cellOwner;

    public CellPhone(String name){
        super(name);
    }

    @Override
    public String getLocation() {
        return ;
    }

    @Override
    public Object getTrace() {
        return null;
    }

    @Override
    public void track() {

    }
}

