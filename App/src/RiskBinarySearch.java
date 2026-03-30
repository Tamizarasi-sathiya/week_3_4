public class RiskBinarySearch {static void linear(int[] a,int t){
    int comp=0;
    for(int i=0;i<a.length;i++){
        comp++;
        if(a[i]==t){
            System.out.println("Found at "+i+" comparisons: "+comp);
            return;
        }
    }
    System.out.println("Not found comparisons: "+comp);
}

    static void floorCeil(int[] a,int t){
        int l=0,h=a.length-1,f=-1,c=-1,comp=0;
        while(l<=h){
            comp++;
            int m=(l+h)/2;
            if(a[m]<=t){f=a[m];l=m+1;}
            else{c=a[m];h=m-1;}
        }
        System.out.println("Floor: "+f+" Ceiling: "+c+" comparisons: "+comp);
    }

    public static void main(String[] args){
        int[] a={10,25,50,100};

        linear(a,30);
        floorCeil(a,30);
    }
}
