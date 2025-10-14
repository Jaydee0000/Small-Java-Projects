/******************************************************************************

Juan Esquivel
DS&A

*******************************************************************************/
import java.util.*;

public class balancedSymbol
{
    public static void main(String[] args) 
    {
        List<String> symbols = new ArrayList<>(Arrays.asList("/*", "*/", "(", ")", "[", "]", "{", "}"));
        Stack<String> symbStack = new Stack<>();

        for (String current : symbols) 
        {
            if (opening(current)) 
            {
                symbStack.push(current);
            } 
            
            else 
            {
                if (symbStack.empty()) 
                {
                    System.out.println(current + " was found before an opening symbol. Not balanced");
                    return;
                }

                String prevSymb = symbStack.pop();
                if (!match(prevSymb, current))
                {
                    System.out.println(prevSymb + " and " + current + " are incompatible.");
                    return;
                }
            }
        }

        if (symbStack.isEmpty())
        {
            System.out.println("All symbols are balanced.");
        } 
        
        else 
        {
            System.out.print("All the unmatched symbols: ");
            while (!symbStack.isEmpty())
            {
                System.out.print(symbStack.pop() + " ");
            }
            System.out.println();
        }
    }

    public static boolean opening(String s)
    {
        return s.equals("/*") || s.equals("(") || s.equals("[") || s.equals("{");
    }

    public static boolean match(String a, String b) 
    {
        return (a.equals("/*") && b.equals("*/")) ||
               (a.equals("(") && b.equals(")")) ||
               (a.equals("[") && b.equals("]")) ||
               (a.equals("{") && b.equals("}"));
    }
}
