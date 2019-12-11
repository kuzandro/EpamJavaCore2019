package epam.homework4.storage;

import epam.homework4.cargo.Cargo;

public class NodeCargo {
    public NodeCargo previous;
    public NodeCargo next;
    private Cargo data;


    public Cargo getData() {
        return data;
    }

    public void setData(Cargo data) {
        this.data = data;
    }

    public NodeCargo(Cargo data) {
        this.data = data;
    }

    public boolean isNotLast() {
        boolean flag = true;
        if (next == null) {
            flag = false;
        }
        System.out.println("is not last: " + flag);
        return flag;
    }

    public void printCargoNode(){
        if (previous == null) {
            System.out.println("no previous");
        } else if (next == null) {
            System.out.println("no next");
        } else {
            System.out.println("This node " + data.getName());
            System.out.println("previous node " + previous.getData().getName());
            System.out.println("next node " + next.getData().getName() + "\n");
        }

    }
}
