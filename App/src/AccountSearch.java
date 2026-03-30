import java.util.Arrays;

public class AccountSearch {

    static int linearFirst(String[] a,String t){
        int comp=0;
        for(int i=0;i<a.length;i++){
            comp++;
            if(a[i].equals(t)){
                System.out.println("Linear first index: "+i+" comparisons: "+comp);
                return i;
            }
        }
        System.out.println("Not found comparisons: "+comp);
        return -1;
    }

    static int binary(String[] a,String t){
        int l=0,h=a.length-1,comp=0;
        while(l<=h){
            comp++;
            int m=(l+h)/2;
            if(a[m].equals(t)){
                System.out.println("Binary index: "+m+" comparisons: "+comp);
                return m;
            }
            else if(a[m].compareTo(t)<0) l=m+1;
            else h=m-1;
        }
        return -1;
    }

    static int count(String[] a,String t){
        int c=0;
        for(String s:a) if(s.equals(t)) c++;
        return c;
    }

    public static void main(String[] args){
        String[] a={"accB","accA","accB","accC"};
        Arrays.sort(a);

        System.out.println("Sorted: "+Arrays.toString(a));
        linearFirst(a,"accB");
        binary(a,"accB");
        System.out.println("Count: "+count(a,"accB"));
    }
}