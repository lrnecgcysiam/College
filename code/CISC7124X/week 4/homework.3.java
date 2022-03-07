// Chris Samuel
// 24141468
// * 
//  *  % java InfixToPostfix
//  *  ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
//  *  [Ctrl-d]
//  *  2 3 4 + 5 6 * * + 
//  *
//  *  % java InfixToPostfix
//  *  ( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )
//  *  5 7 1 1 + * + 3 * 2 1 1 + * + 
//  *
//  *  % java InfixToPostfix | java EvaluatePostfix
//  *  ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
//  *  [Ctrl-d]
//  *  212
//  *
//  ******************************************************************************/


public static String infixToPostfix(String expression) {
    StringBuilder ans = new StringBuilder();

    // Implement the HashMap
    Map m1 = new Hashmap();
    m1.put('(', 0);
        m1.put('+', 1);
        m1.put('-', 1);
        m1.put('*', 2);
        m1.put('/', 2);
        m1.put(')', 3);
        int i;
        Stack st = new Stack();
        for(i=0;i<expression.length();i++)
        {
            char ch = expression.charAt(i);
            if(m1.containsKey(ch))
            {
                if(st.empty())
                {
                    st.push(ch);
                }
                else if((int)m1.get(ch)==3)
                {
                    while((char)st.peek()!='(')
                    {
                        ans.append((char)st.pop());
                    }
                    st.pop();
                }
                else if((int)m1.get(ch)==0)
                {
                   st.push(ch);
                }
                else
                {
                    if((int)m1.get(ch)>(int)m1.get((char)st.peek()))
                    {
                        st.push(ch);
                    }
                    else
                    {
                        ans.append((char)st.pop());
                        st.push(ch);
                    }
                }
            }
            else
            {
                ans.append(ch);
            }
        }
        while(!st.empty())
        {
            ans.append((char)st.pop());
        }
        return ans.toString();
    }
}


public static List<Character> take(List<Character> lst,int n) {
    if(lst == null) {
        return lst;
    }
    if(lst.size() <= n) {
        return lst;
    }
    return lst.subList(0, n);
}

// 1.1
public static List<List<Character>> sublists(List<Character> lst,int n) {
    List<List<Character>> lists = new ArrayList<>();

    int len = lst.size();
    for(int i=0; i<len-n; i++) {
        lists.add(lst.subList(i, i + n));
    }

    return lists;
}



    public ListNode drop(ListNode head) {        
        
        if (head == null || head.next == null)
            return head;
        
        ListNode prevNode = head;
        ListNode result = prevNode;
        ListNode nextNode = prevNode.next;
        
        while (nextNode != null)
        {
            if (nextNode.val == prevNode.val)            
                prevNode.next = nextNode.next;           
            else            
                prevNode = prevNode.next;            
            nextNode = nextNode.next;                        
        }
        return result;
    }





import java.util.Scanner;

public class SortedDown {

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many number? ");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " non-zero integers: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        if(isSorted(arr)) {
            System.out.println("These numbers are in ascending order");
        } else {
            System.out.println("These numbers are not in ascending order");
        }

        in.close();
    }

}


// Homework 3  Problem 2

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Arrays;

public class Driver

{

   private static void merge(ArrayList<String> left, ArrayList<String> right, ArrayList<String> whole) {

       int leftside = 0;

       int rightside = 0;

       int wholeSize = 0;

       // As long as neither the left nor the right ArrayList has

       // been used up, keep taking the smaller of left.get(leftside)

       // or right.get(rightside) and adding it at both.get(bothIndex).

       while (leftside < left.size() && rightside < right.size()) {

           if ( (left.get(leftside).compareTo(right.get(rightside))) < 0) {

               whole.set(wholeIndex, left.get(leftside));

               leftside++;

           } else {

               whole.set(wholeIndex, right.get(rightside));

               rightside++;

           }

           wholeIndex++;

       }

       ArrayList<String> rest;

       int restIndex;

       if (leftside >= left.size()) {

           // The left ArrayList has been use up...

           rest = right;

           restIndex = rightside;

       } else {

           // The right ArrayList has been used up...

           rest = left;

           restIndex = leftside;

       }

       // Copy the rest of whichever ArrayList (left or right) was not used up.

       for (int i=restIndex; i<rest.size(); i++) {

           whole.set(wholeIndex, rest.get(i));

           wholeIndex++;

       }

   }

   public static ArrayList<String> mergeSort(ArrayList<String> whole) {

       ArrayList<String> left = new ArrayList<String>();

       ArrayList<String> right = new ArrayList<String>();

       int center;

       if (whole.size() == 1) {

           return whole;

       } else {

           center = whole.size()/2;

           // copy the left half of whole into the left.

           for (int i=0; i<center; i++) {

               left.add(whole.get(i));

           }

           //copy the right half of whole into the new arraylist.

           for (int i=center; i<whole.size(); i++) {

               right.add(whole.get(i));

           }

           // Sort the left and right halves of the arraylist.

           left = mergeSort(left);

           right = mergeSort(right);

           // Merge the results back together.

           merge(left, right, whole);

       }

       return whole;

   }

   /** Main function **/

   public static void main (String[] args) {

       String fileName = args[0];

       BufferedReader br = null;

       FileReader fr = null;

       ArrayList<String> words = new ArrayList<>();

       try {

           //br = new BufferedReader(new FileReader(FILENAME));

           fr = new FileReader(fileName);

           br = new BufferedReader(fr);

           String sCurrentLine;

           while ((sCurrentLine = br.readLine()) != null) {

               words.addAll(Arrays.asList(sCurrentLine.split(" ")));

           }

           mergeSort(words);

          

           System.out.println("The words sorted in ascending alphabetical order are: ");

           System.out.println(words);

          

       } catch (IOException e) {

           e.printStackTrace();

       } finally {

           try {

               if (br != null)

                   br.close();

               if (fr != null)

                   fr.close();

           } catch (IOException ex) {

               ex.printStackTrace();

           }

       }

   }

}

// Homework 3 Problem 4 Heap _sort Algorithm
// Merge all the linked-lists into one sorted linked-list and return it.\
// lists[i] is sorted in ascending order.

class Solution {
    public ListNode heapSort(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode e: lists) 
            if (e != null) pq.add(e);
        
        ListNode ret = new ListNode();
        ListNode tmp = ret;
        while (!pq.isEmpty()) {
            ListNode e = pq.poll();
            tmp.next = e;
            tmp = tmp.next;
            if (e.next != null) pq.add(e.next);
        }
        
        return ret.next;
    }
}




// Homework 3 Grouping symbols can not overlap

public String evaluate(String s, List<List<String>> knowledge) {
	Map<String, String> map = new HashMap<>();
	for(List<String> k: knowledge) 
		map.put(k.get(0), k.get(1));
	StringBuffer result = new StringBuffer(), key = new StringBuffer();
	boolean isKey =false;
	for(int i=0;i<s.length();i++)
		if(s.charAt(i) == ')' && isKey==true) {
			isKey = false;
			if(map.containsKey(key.toString())) result.append(map.get(key.toString()));
			else result.append("?");
			key.setLength(0);
		} else if(isKey) key.append(s.charAt(i));
		else if(isKey == false && s.charAt(i) == '(')  isKey = true;
		else result.append(s.charAt(i));
	return result.toString();
}