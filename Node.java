/** Praxis der Programmierung SoSe20, Hausaufgabe 2 - Java
 * Christian Mosau
 * */

import java.util.*;


public class Node<T>{
    
    // Variablen
    private String NodeName; //Variable um den Knotennamen zu speichern
    private T NodeValue; // Variable um den Knotenwert zu speichern
    private LinkedList<Node<?>> NodeNeighbours = new LinkedList<Node<?>>();


    // Initalisierungskonstrukutor
    public Node(){
        NodeName = null;
        NodeValue = null;
    }

    public Node(String ArgNodeName, T ArgNodeValue) {
        this.NodeName = ArgNodeName;
        this.NodeValue = ArgNodeValue;
    }

    // Getter
    public String getNodeName(){
        return NodeName;
    }

    public T getNodeValue() {
        return NodeValue;
    }

    // Setter
    public void setNodeValue(T argSetNodeValue) {
        this.NodeValue = argSetNodeValue;
    }

        // Methoden connect und disconnect!!!
        public void connect(Node<?> NodeArg2) {
            if (NodeNeighbours.contains(NodeArg2)) { // Prüfen ob der Knoten schon vorhanden ist, wenn ja, Methode beenden
                return;
            } else {
                // Den Verweis des Knotens speichern in der Instanz, wo die Methode aufgerufen wird und in der Instanz, mit der verbunden wird
                this.NodeNeighbours.add(NodeArg2);
                NodeArg2.NodeNeighbours.add(this);
            }
            
        }

        public void disconnect(Node<?> NodeArg2) {
            if (this.NodeNeighbours.contains(NodeArg2)) { // Prüfen ob der Knoten schon vorhanden ist, wenn ja, löschen in beiden Objekten
                // Die Adresse löschen
                NodeArg2.NodeNeighbours.remove(this);
                this.NodeNeighbours.remove(NodeArg2);
            }
        }

        public LinkedList<Node<?>> traverse() {
            LinkedList<Node<?>> NodesList = new LinkedList<Node<?>>(); //Neue Linkedlist erstellen, wo alle Knoten gespeicht werden
            LinkedList<Node<?>> QueueList = new LinkedList<Node<?>>(); //Speicher für die Breitensuche
            
            // Startknoten in die Liste eingeben
            NodesList.add(this);
            QueueList.add(this);
            
            
            //Iterator auf die NodesList
            Iterator<Node<?>> ite = this.NodeNeighbours.iterator();
            
    
            while (ite.hasNext()) { // Solange es weitere Knoten in der Liste gibt
                Node<?> temp = ite.next(); //Die Refrenz des Objektes nehmen
                NodesList.add(temp);
                QueueList.add(temp);
            }
            
            //Leerknoten als Abbruch-Bedingung für die while-Schleife
            Node<?> checker = new Node<T>();
            
            while (checker != null) {
                Node<?> temp2 = QueueList.pollFirst(); //ersten Knoten aus der Queue ziehen (falls leer, dann wird null zurückgegeben)
                if (temp2 != null) {
    
                    Iterator<Node<?>> ite2 = temp2.NodeNeighbours.iterator(); //neuen Iterator initalisieren für die Knotennachbarn
                    while (ite2.hasNext()) {
                        Node<?> temp3 = ite2.next(); //Die Knoten aus der Liste entnehmen
    
                        if (NodesList.contains(temp3)) { //prüfen ob der Knoten schon vorhanden ist, wenn ja, überspringen, wenn nein einfügen
                            continue;
                        } else {
                            NodesList.add(temp3);
                            QueueList.add(temp3);
                        }
                    }
                }
                checker = temp2;
            }
    
            return NodesList;
        }

}