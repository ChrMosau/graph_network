
import java.util.Iterator;

class UseNode_Hausaufgabe02 {
    
    public static void main(String args[]) {
        // DIe ganzen Knoten erstellen
        Node<String> Knoten_A = new Node<String>("A", "a");
        Node<Integer> Knoten_G = new Node<Integer>("G", 6);
        Node<String> Knoten_F = new Node<String>("F", "17");
        Node<String> Knoten_B = new Node<String>("B", "8");
        Node<String> Knoten_C = new Node<String>("C", "9");
        Node<String> Knoten_D = new Node<String>("D", "1");
        Node<String> Knoten_E = new Node<String>("E", "8");

        //Verbindungen setzen
        System.out.println("Es wird das Netzwerk aufgebaut.");
        Knoten_A.connect(Knoten_G);
        Knoten_A.connect(Knoten_F);

        Knoten_F.connect(Knoten_A);
        Knoten_F.connect(Knoten_B);
        Knoten_F.connect(Knoten_G);
        Knoten_F.connect(Knoten_C);

        Knoten_G.connect(Knoten_A);
        Knoten_G.connect(Knoten_B);
        Knoten_G.connect(Knoten_F);

        Knoten_B.connect(Knoten_G);
        Knoten_B.connect(Knoten_F);

        Knoten_C.connect(Knoten_F);
        Knoten_C.connect(Knoten_D);

        Knoten_D.connect(Knoten_C);
        Knoten_D.connect(Knoten_E);

        Knoten_E.connect(Knoten_D);

        System.out.println("Das Netzwerk des Knoten A besteht aus:");
        Iterator<Node<?>> NetzwerkIte = Knoten_A.traverse().iterator();
        while (NetzwerkIte.hasNext()) {
            Node<?> temp = NetzwerkIte.next();
            System.out.println("Der Knotenname: " + temp.getNodeName() + " und dem Knotenwert " + temp.getNodeValue());
        }

        //Disconnect
        System.out.println("Disconnect F und C:");
        Knoten_F.disconnect(Knoten_C);

        //Das Netzwerk ausgeben
        
        System.out.println("Das Netzwerk des Knoten A nach dem Disconnect von F und C besteht  aus:");
        Iterator<Node<?>> NetzwerkIte2 = Knoten_A.traverse().iterator();
        while (NetzwerkIte2.hasNext()) {
            Node<?> temp = NetzwerkIte2.next();
            System.out.println("Der Knotenname: " + temp.getNodeName() + " und dem Knotenwert " + temp.getNodeValue());
        }

    }
}