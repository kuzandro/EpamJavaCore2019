package epam.homework4.storage;

import epam.homework4.cargo.Cargo;
import epam.homework4.carrier.Carrier;
import epam.homework4.transportation.Transportation;
import org.w3c.dom.Node;

public class Storage {
    private NodeCargo headCargo;

    public void addCargo(Cargo newCargo) {
        if (headCargo == null) {
            System.out.println("no head");
            System.out.println("will put there " + newCargo.getName());
            headCargo = new NodeCargo(newCargo);
            System.out.println("there are in head " + headCargo.getData().getName());

        } else {
            NodeCargo currentNode = headCargo;
            currentNode.printCargoNode();
            while (currentNode.isNotLast()) {
                currentNode = currentNode.next;
                currentNode.printCargoNode();
                System.out.println("go to next node");
            }
            System.out.println("no next node");
            NodeCargo addedNode = new NodeCargo(newCargo);
            addedNode.previous = currentNode;
            System.out.println("added node " + addedNode.getData().getName());
        }
    }

    public void printCargos() {
        if (headCargo == null) {
            System.out.println("No cargos in the storage");
        } else {
            NodeCargo currentNode = headCargo;
            while (currentNode.next != null) {
                System.out.println(currentNode.getData().getName());
                currentNode = currentNode.next;
            }
        }
    }

}
