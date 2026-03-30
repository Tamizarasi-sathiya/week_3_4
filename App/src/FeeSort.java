import java.util.*;

public class FeeSort {

    static class Transaction {
        String id;
        double fee;
        String ts;
        Transaction(String i,double f,String t){id=i;fee=f;ts=t;}
    }

    static void bubble(List<Transaction> a){
        int passes=0,swaps=0;
        for(int i=0;i<a.size()-1;i++){
            boolean flag=false;
            for(int j=0;j<a.size()-i-1;j++){
                if(a.get(j).fee>a.get(j+1).fee){
                    Collections.swap(a,j,j+1);
                    swaps++;
                    flag=true;
                }
            }
            passes++;
            if(!flag) break;
        }
        System.out.println("BubbleSort (fees):");
        for(Transaction t:a) System.out.print(t.id+":"+t.fee+" ");
        System.out.println("\nPasses="+passes+" Swaps="+swaps);
    }

    static void insertion(List<Transaction> a){
        for(int i=1;i<a.size();i++){
            Transaction key=a.get(i);
            int j=i-1;
            while(j>=0 && (a.get(j).fee>key.fee || (a.get(j).fee==key.fee && a.get(j).ts.compareTo(key.ts)>0))){
                a.set(j+1,a.get(j));
                j--;
            }
            a.set(j+1,key);
        }
        System.out.println("InsertionSort (fee+ts):");
        for(Transaction t:a) System.out.print(t.id+":"+t.fee+"@"+t.ts+" ");
        System.out.println();
    }

    static void outliers(List<Transaction> a){
        System.out.print("High-fee outliers: ");
        boolean found=false;
        for(Transaction t:a){
            if(t.fee>50){
                System.out.print(t.id+" ");
                found=true;
            }
        }
        if(!found) System.out.print("none");
        System.out.println();
    }

    public static void main(String[] args){
        List<Transaction> list=new ArrayList<>();
        list.add(new Transaction("id1",10.5,"10:00"));
        list.add(new Transaction("id2",25.0,"09:30"));
        list.add(new Transaction("id3",5.0,"10:15"));

        bubble(list);

        insertion(list);

        outliers(list);
    }
}