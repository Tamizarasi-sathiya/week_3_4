public class RiskRanking {static class Client{
    String name;
    int risk;
    int balance;
    Client(String n,int r,int b){name=n;risk=r;balance=b;}
}

    static void bubble(Client[] a){
        int swaps=0;
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j].risk>a[j+1].risk){
                    Client t=a[j];a[j]=a[j+1];a[j+1]=t;
                    swaps++;
                }
            }
        }
        System.out.print("Bubble (asc): ");
        for(Client c:a) System.out.print(c.name+":"+c.risk+" ");
        System.out.println("\nSwaps: "+swaps);
    }

    static void insertion(Client[] a){
        for(int i=1;i<a.length;i++){
            Client key=a[i];
            int j=i-1;
            while(j>=0 && (a[j].risk<key.risk || (a[j].risk==key.risk && a[j].balance>key.balance))){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
        System.out.print("Insertion (desc): ");
        for(Client c:a) System.out.print(c.name+":"+c.risk+" ");
        System.out.println();
    }

    static void top(Client[] a){
        System.out.print("Top risks: ");
        for(int i=0;i<Math.min(10,a.length);i++)
            System.out.print(a[i].name+"("+a[i].risk+") ");
        System.out.println();
    }

    public static void main(String[] args){
        Client[] a={
                new Client("C",80,1000),
                new Client("A",20,2000),
                new Client("B",50,1500)
        };

        bubble(a);
        insertion(a);
        top(a);
    }
}
