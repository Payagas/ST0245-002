
public class Bees
{
    public static LinkedListBoolean createBeeHive(int size){
        LinkedListBoolean bees = new LinkedListBoolean();
        for(int i=0; i<size; i++){
            bees.insert(false,i);
        }
        return bees;
    }
    
    public static int findBees(LinkedListBoolean list){
        int cont = 0;
        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)) {
                    cont++;
                    System.out.println("Abeja en posicion: " + i);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La posicion no existe");
        }
        if(cont == 0) System.out.println("No hay abejas.");
        return cont;
    }
    
    public static void main(String[]bees){
        LinkedListBoolean bees1 = createBeeHive(27);
        LinkedListBoolean bees2 = createBeeHive(20);
        LinkedListBoolean bees3 = createBeeHive(30);
        
        bees1.insert(true,4);
        bees1.insert(true,15);
        bees1.insert(true,27);
        
        for(int i=2; i<30; i += 3){
            bees2.insert(true,i);
        }
        
        System.out.println("Abejas en el primer conjunto: ");
        int b1 = findBees(bees1);
        System.out.println("Se encontraron "+b1+" abejas");
        System.out.println();
        
        System.out.println("Abejas en el segundo conjunto: ");
        int b2 = findBees(bees2);
        System.out.println("Se encontraron "+b2+" abejas");
        System.out.println();
        
        System.out.println("Abejas en el tercer conjunto: ");
        int b3 = findBees(bees3);
        System.out.println("Se encontraron "+b3+" abejas");
    }
}
