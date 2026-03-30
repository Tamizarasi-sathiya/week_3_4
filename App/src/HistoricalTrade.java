public class HistoricalTrade {

    static void mergeSort(int[] a,int l,int r){
        if(l>=r) return;
        int m=(l+r)/2;
        mergeSort(a,l,m);
        mergeSort(a,m+1,r);
        merge(a,l,m,r);
    }

    static void merge(int[] a,int l,int m,int r){
        int[] t=new int[r-l+1];
        int i=l,j=m+1,k=0;
        while(i<=m && j<=r){
            if(a[i]<=a[j]) t[k++]=a[i++];
            else t[k++]=a[j++];
        }
        while(i<=m) t[k++]=a[i++];
        while(j<=r) t[k++]=a[j++];
        for(i=0;i<t.length;i++) a[l+i]=t[i];
    }

    static void quickSort(int[] a,int l,int r){
        if(l<r){
            int p=part(a,l,r);
            quickSort(a,l,p-1);
            quickSort(a,p+1,r);
        }
    }

    static int part(int[] a,int l,int r){
        int p=a[r],i=l-1;
        for(int j=l;j<r;j++){
            if(a[j]>=p){
                i++;
                int t=a[i];a[i]=a[j];a[j]=t;
            }
        }
        int t=a[i+1];a[i+1]=a[r];a[r]=t;
        return i+1;
    }

    static int total(int[] a){
        int s=0;
        for(int x:a) s+=x;
        return s;
    }

    public static void main(String[] args){
        int[] a={500,100,300};

        mergeSort(a,0,a.length-1);
        System.out.print("MergeSort: ");
        for(int x:a) System.out.print(x+" ");
        System.out.println();

        quickSort(a,0,a.length-1);
        System.out.print("QuickSort (desc): ");
        for(int x:a) System.out.print(x+" ");
        System.out.println();

        System.out.println("Total volume: "+total(a));
    }
}

