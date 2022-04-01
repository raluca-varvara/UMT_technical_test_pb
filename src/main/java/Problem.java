import java.util.Scanner;

public class Problem {
    //retinem array-ul, elementul la care am ajuns(in ordine inversa, adica numar de la n la 0) l este lungimea primului subset, sumCalc este suma primului subset
    //si sum total este suma intregului array, pentru al doilea subset putem calcula din informatiile despre tot arrayul - infor despre primul subset
    //sumSet2=sumtotal-sumSet1
    //lengthSet2=array.length-lengthSet1
    public static boolean sameAverage(int arr[], int i, int l, int sumCalculated, int sumTotal)
    {
        // daca am ajuns la ultimul element
        // avem suma calculata pt un subset, pentru celalat subset o calculam prin scaderea din suma totala
        // avem in variabila l lungimea primului subset, si calculam media la ambele, primul subset va avea media suma lui/l, iar
        // celalat subset va avea suma calculata (suma totala-sumasubset1) si numarul de elemente il aflam prin scaderea din numarul total de elemente, numarul de elemente al primului subset
        // daca unul dintre subsetul are lungimea 0, atunci nu o sa aiba cele 2 subseturi media egala, cel gol va avea media 0, deci verificam si acest caz la inceput
        if (i == 0)
            if(l!=0 && l!= arr.length && (double)sumCalculated/l==(double)(sumTotal-sumCalculated)/(arr.length-l)){
                System.out.println((double)sumCalculated/l+" "+((double)(sumTotal-sumCalculated)/(arr.length-l)));
                return true;
            }
            else
                return false;

        // pentru fiecare element al listei putem avea 2 alegeri, il punem in primul subset sau nu
        // daca pentru una din variante outputul o sa fie adevarat(se poate imparti) rezultatul tot va fi adevarat deci vom returna un SAU intre cele 2 rezultate
        return
                sameAverage(arr, i - 1, l+1,
                        sumCalculated + arr[i - 1],
                        sumTotal) ||
                sameAverage(arr, i - 1,l, sumCalculated,
                        sumTotal);
    }
    public static boolean sameAverageSubsets(int arr[], int n)
    {
        // se calculeaza suma
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // Compute result using recursive function
        return sameAverage(arr, n, 0,0, sum);
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        //int arr[] = { 1,2,3,4,5,6,7,8 };
        //int n = arr.length;

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[]= new int[n];
        for(int i = 0; i<n; i++)
            arr[i]=in.nextInt();


        if(sameAverageSubsets(arr, n))
            System.out.println("The array can be divided in 2 subsets with same average");
        else
            System.out.println("The array CAN NOT be divided in 2 subsets with same average");
    }
}
