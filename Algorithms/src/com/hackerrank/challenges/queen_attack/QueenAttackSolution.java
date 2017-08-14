package com.hackerrank.challenges.queen_attack;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueenAttackSolution {

    public static int n;
	public static int k;
	public static int rQueen;
	public static int cQueen;
	public static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        rQueen = n-in.nextInt();
        cQueen = in.nextInt()-1;
        count=0;
        addBlock();
        System.out.println(count);
        int cLMax=-1;
        int cRMin=n;
        int rMax=-1;
        
        int rUMax=-1;
        int rDMin=n;
        int cMax=-1;
       
        int rDUMax=-1;
        int cDUMax=n;
        int rDDMin=n;
        int cDDMin=-1;
        int rDU2Max=-1;
        int cDU2Max=-1;
        int rDD2Min=n;
        int cDD2Min=n;
        for(int a0 = 0; a0 < k; a0++){
           int rObstacle = n-in.nextInt();
           int cObstacle = in.nextInt()-1;
            
           if(rObstacle==rQueen)
            {
                if (cObstacle < cQueen) 
                {
                    if(cObstacle>cLMax)
                    {
                        cLMax=cObstacle;
                    }
                }
                else if (cObstacle > cQueen)
                {
                    if(cObstacle<cRMin)
                    {
                        cRMin=cObstacle;
                    }
                }
                rMax=rObstacle;
                
            }
            else if(cObstacle==cQueen)
            {
                
                if (rObstacle < rQueen) 
                {
                    
                    if(rObstacle>rUMax)
                    {
                        rUMax=rObstacle;
                                               
                    }
                }
                else if (rObstacle > rQueen)
                {
                    if(rObstacle<rDMin)
                    {
                        rDMin=rObstacle;
                    }
                }
                cMax=cObstacle;
            }
            else if (rObstacle + cObstacle == rQueen + cQueen)
            {
                 if (rObstacle < rQueen) 
                 {
                     if(rObstacle>rDUMax)
                     {
                        rDUMax=rObstacle;
                        cDUMax=cObstacle;
                     }
                 }
                else if (rObstacle > rQueen)
                {
                    if(rObstacle<rDDMin)
                    {
                        rDDMin=rObstacle;
                        cDDMin=cObstacle;
                    }
                }
            
            }
            else if (rObstacle - cObstacle  == rQueen - cQueen) 
            {
                if (rObstacle < rQueen) 
                 {
                     if(rObstacle>rDUMax)
                     {
                        rDU2Max=rObstacle;
                        cDU2Max=cObstacle;
                     }
                 }
                else if (rObstacle > rQueen)
                {
                    if(rObstacle<rDDMin)
                    {
                        rDD2Min=rObstacle;
                        cDD2Min=cObstacle;
                    }
                }
            }
            
        } 
        System.out.println(rQueen +" " + cQueen);
        System.out.println(rMax +" " + cLMax);
            System.out.println(rMax +" " + cRMin);
            System.out.println(rUMax +" " + cMax);
            System.out.println(rDMin +" " + cMax);
            System.out.println(rDUMax +" " + cDUMax);
            System.out.println(rDDMin +" " + cDDMin);
            System.out.println(rDU2Max +" " + cDU2Max);
            System.out.println(rDD2Min +" " + cDD2Min);
        removeBlock(rMax, cLMax, 1);
        removeBlock(rMax, cRMin, 2);
        removeBlock(rUMax, cMax, 3);
        removeBlock(rDMin, cMax, 4);
        removeBlock(rDUMax, cDUMax, 5);
        removeBlock(rDDMin, cDDMin, 6);
        removeBlock(rDU2Max, cDU2Max, 7);
        removeBlock(rDD2Min, cDD2Min, 8);
                 
        System.out.println(count);
    }
   
    static void addBlock() {
       
        count=2*(n-1);
        int j=cQueen+1;
        for(int i=rQueen+1;i<n;i++)
        {
            if(j==n)
            {
                break;
            }
            count++;
            j++;
        }
        
        j=cQueen-1;
        for(int i=rQueen-1;i>=0;i--)
        {
            if(j<0)
            {
                break;
            }
            count++;
            j--;
            
        }
        j=cQueen-1;
         for(int i=rQueen+1;i<n;i++)
        {
            if(j<0)
            {
                break;
            }
            count++;
            j--;
        }
        j=cQueen+1;
        for(int i=rQueen-1;i>=0;i--)
        {
           if(j==n)
           {
                break;
           }
            count++;
            j++;
        }
            
		
	}

	static void removeBlock(int r, int c, int cs) {
        int j;
      if(r==n || r==-1 || c==n || c==-1)
      {
        //  System.out.println(r +" " + c);
          return;
      }
      switch(cs)
      {
          case 1: for(int k=0;k<=c;k++)
                  {
                    count--;
                   }
                  break;
          case 2: for(int k=c;k<n;k++)
                    {
                    count--;
                    }
                  break;
          case 3: for(int i=0;i<=r;i++)
                    {
                    count--;
                    }
                  break;
          case 4: for(int i=r;i<n;i++)
                    {
                     count--;
                     }
                  break;
          case 5: j=c;        
                  for(int i=r;i>=0;i--)
                  {
                    if(j==n)
                        break;
                    count--;
                    j++;
                  }
                  break;
          case 6: j=c;
                  for(int i=r;i<n;i++)
                  {
                    if(j<0)
                        break;
                    count--;
                    j--;
                   }
                   break;
          case 7: j=c;
                  for(int i=r;i>=0;i--)
                  {
                    if(j<0)
                      break;
                    count--;
                    j--;
                  }
                    break;
          case 8: j=c;
                  for(int i=r;i<n;i++)
                  {
                    if(j==n)
                        break;
                    count--;
                    j++;
                }
                break;
          
      }
      
          
       
	}
}

