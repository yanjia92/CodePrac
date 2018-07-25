import java.util.*;

/**
 * Created by bitbook on 3/24/18.
 */
public class Main {

    static char[][] m0 = {
            "66666".toCharArray(),
            "6...6".toCharArray(),
            "6...6".toCharArray(),
            "6...6".toCharArray(),
            "66666".toCharArray()
    };

    static char[][] m1 = {
            "....6".toCharArray(),
            "....6".toCharArray(),
            "....6".toCharArray(),
            "....6".toCharArray(),
            "....6".toCharArray()
    };

    static char[][] m2 = {
            "66666".toCharArray(),
            "....6".toCharArray(),
            "66666".toCharArray(),
            "6....".toCharArray(),
            "66666".toCharArray()
    };

    static char[][] m3  = {
            "66666".toCharArray(),
            "....6".toCharArray(),
            "66666".toCharArray(),
            "....6".toCharArray(),
            "66666".toCharArray()
    };

    static char[][] m4 = {
            "6...6".toCharArray(),
            "6...6".toCharArray(),
            "66666".toCharArray(),
            "....6".toCharArray(),
            "....6".toCharArray()
    };

    static char[][] m5 = {
            "66666".toCharArray(),
            "6....".toCharArray(),
            "66666".toCharArray(),
            "....6".toCharArray(),
            "66666".toCharArray()
    };

    static char[][] m6 = {
            "66666".toCharArray(),
            "6....".toCharArray(),
            "66666".toCharArray(),
            "6...6".toCharArray(),
            "66666".toCharArray()
    };

    static char[][] m7 = {
            "66666".toCharArray(),
            "....6".toCharArray(),
            "....6".toCharArray(),
            "....6".toCharArray(),
            "....6".toCharArray()
    };

    static char[][] m8= {
            "66666".toCharArray(),
            "6...6".toCharArray(),
            "66666".toCharArray(),
            "6...6".toCharArray(),
            "66666".toCharArray()
    };

    static char[][] m9 = {
            "66666".toCharArray(),
            "6...6".toCharArray(),
            "66666".toCharArray(),
            "....6".toCharArray(),
            "66666".toCharArray()
    };



    static ArrayList<char[][]> ms = new ArrayList<>(10);
    static {
        ms.add(m0);
        ms.add(m1);
        ms.add(m2);
        ms.add(m3);
        ms.add(m4);
        ms.add(m5);
        ms.add(m6);
        ms.add(m7);
        ms.add(m8);
        ms.add(m9);
    }


    static int evalsimple(String s) {
        if (s.contains("+")) {
            return Integer.parseInt(s.substring(0, 1)) + Integer.parseInt(s.substring(2, 3));
        } else if (s.contains("*")) {
            return Integer.parseInt(s.substring(0, 1)) * Integer.parseInt(s.substring(2, 3));
        } else {
            return Integer.parseInt(s);
        }
    }

    static int eval(String s) {
        //将中缀表达式转化为后缀表达式
        Queue<Object> queue = new LinkedList<Object>();
        Stack<Character> stack = new Stack<Character>();
        int x = 0;
        boolean isInt =false;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch>='0'&&ch<='9'){
                x = x*10 + ch-'0';
                isInt = true;
            }else{
                if(isInt)
                    queue.add((Integer)x);
                x = 0;
                isInt = false;
                if(ch=='('){
                    stack.push(ch);
                }else if(ch==')'){
//                      System.out.println(stack);
//                      System.out.println(queue);
                    while(stack.peek()!='('){
//                          System.out.println(stack.peek());
                        queue.add(stack.pop());
                    }
                    stack.pop();
                }else{
                    while(!stack.empty() && rank(stack.peek())>=rank(ch)){
                        queue.add(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }
        if(x!=0) queue.add(x);
        while(!stack.empty()) queue.add(stack.pop());

//          计算逆波兰表达式
        Stack<Integer> integers = new Stack<Integer>();
        for(Object object : queue){
            if(object instanceof Integer){
                integers.push((Integer)object);
            }else{
                int b = integers.pop();
                int a = integers.pop();
                char op = (Character)object;
                if(op=='+') integers.push(a+b);
                else if(op=='-') integers.push(a-b);
                else if(op=='*') integers.push(a*b);
                else integers.push(a/b);
            }
        }
        return integers.peek();
    }

    private static int rank(char ch){
        if(ch=='+'||ch=='-'){
            return 1;
        }else if(ch=='*' || ch=='/'){
            return 2;
        }else{  //( )
            return 0;   //( ) 的优先级应该跟高，但这里为了代码的简洁，将其设为最小
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()) {
            int cases = scanner.nextInt();
            for (int i = 0; i != cases; i++) {
                String expr = scanner.next();
                int result = evalsimple(expr);
                Stack<Integer> stack = new Stack<>();
                while (result > 0) {
                    stack.push(result % 10);
                    result /= 10;
                }
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                StringBuilder sb4 = new StringBuilder();
                StringBuilder sb5 = new StringBuilder();

                while (!stack.isEmpty()) {
                    int top = stack.pop();
                    sb1.append(new String(ms.get(top)[0]));
                    if (!stack.isEmpty()) {
                        sb1.append(new String(".."));
                    } else {
                        sb1.append("\n");
                    }
                    sb2.append(new String(ms.get(top)[1]));
                    if (!stack.isEmpty()) {
                        sb2.append(new String(".."));
                    } else {
                        sb2.append("\n");
                    }
                    sb3.append(new String(ms.get(top)[2]));
                    if (!stack.isEmpty()) {
                        sb3.append(new String(".."));
                    } else {
                        sb3.append("\n");
                    }
                    sb4.append(new String(ms.get(top)[3]));
                    if (!stack.isEmpty()) {
                        sb4.append(new String(".."));
                    } else {
                        sb4.append("\n");
                    }
                    sb5.append(new String(ms.get(top)[4]));
                    if (!stack.isEmpty()) {
                        sb5.append(new String(".."));
                    } else {
                        sb5.append("\n");
                    }
                }
                System.out.println(sb1.toString());
                System.out.println(sb2.toString());
                System.out.println(sb3.toString());
                System.out.println(sb4.toString());
                System.out.println(sb5.toString());
            }
        }
    }
}
