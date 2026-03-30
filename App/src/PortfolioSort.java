public class PortfolioSort {static class Asset{
    String name;
    double ret;
    double vol;
    Asset(String n,double r,double v){name=n;ret=r;vol=v;}
}

    static void mergeSort(Asset[] a,int l,int r){
        if(l>=r) return;
        int m=(l+r)/2;
        mergeSort(a,l,m);
        mergeSort(a,m+1,r);
        merge(a,l,m,r);
    }

    static void merge(Asset[] a,int l,int m,int r){
        Asset[] t=new Asset[r-l+1];
        int i=l,j=m+1,k=0;
        while(i<=m && j<=r){
            if(a[i].ret<=a[j].ret) t[k++]=a[i++];
            else t[k++]=a[j++];
        }
        while(i<=m) t[k++]=a[i++];
        while(j<=r) t[k++]=a[j++];
        for(i=0;i<t.length;i++) a[l+i]=t[i];
    }

    static void quickSort(Asset[] a,int l,int r){
        if(l<r){
            int p=part(a,l,r);
            quickSort(a,l,p-1);
            quickSort(a,p+1,r);
        }
    }

    static int part(Asset[] a,int l,int r){
        Asset p=a[r];
        int i=l-1;
        for(int j=l;j<r;j++){
            if(a[j].ret>p.ret || (a[j].ret==p.ret && a[j].vol<p.vol)){
                i++;
                Asset t=a[i];a[i]=a[j];a[j]=t;
            }
        }
        Asset t=a[i+1];a[i+1]=a[r];a[r]=t;
        return i+1;
    }

    public static void main(String[] args){
        Asset[] a={
                new Asset("AAPL",12,5),
                new Asset("TSLA",8,7),
                new Asset("GOOG",15,4)
        };

        mergeSort(a,0,a.length-1);
        System.out.print("Merge: ");
        for(Asset x:a) System.out.print(x.name+" ");
        System.out.println();

        quickSort(a,0,a.length-1);
        System.out.print("Quick (desc): ");
        for(Asset x:a) System.out.print(x.name+" ");
    }
}
