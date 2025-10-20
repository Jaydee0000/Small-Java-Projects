/*
Juan Esquivel
Due 12/3/24
Khan


I put comments on the places that i have added. 
I have added the needed code for the 4 

*/
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class bstSearch {

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        readFileRecords(bst, "datafile.txt");

        System.out.println("\t\tWelcome to Information Retrieval System");

        Scanner input = new Scanner(System.in);
        int choice;
        do {
            
            System.out.println("1. InOrder Traversal with Details <Output keywords along with their associated referenced articles.>");
            System.out.println("2. InOrder Traversal (Keywords Only) <Output only the keywords, excluding the referenced articles.>");
            System.out.println("3. PreOrder Traversal (Keywords Only) <Output only the keywords in pre-order traversal, without the referenced articles.> ");
            System.out.println("4. Search for a specific Keyword <If found, display the keyword with referenced articles; otherwise, output the keyword not found message.>");
            System.out.println("5. Exit <Terminates the program.>");
            System.out.print("\nEnter a choice? ");
            choice = input.nextInt();
            
            if (choice == 1) // it executes traversal with all the details
            {
                System.out.println("Executing inOrder Traversal with Details...");
                bst.inOrder(); // executes regular traversal with inOrder Function given
                continue;
            }
            
            else if (choice == 2) // it executes inOrder traversal with only Keywords
            {
                System.out.println("Executing inOrder Traversal (Keywords Only)...");
                bst.InOrderKeyWordsOnly(); // new InOrder Traversal function I made
                continue;
            }
            
            else if (choice == 3) // it executes preOrder Traversal with only key words
            {
                System.out.println("Executing PreOrder Traversal (Keywords Only)...");
                bst.preOrderKeywordsOnly(); // new preOrder Traversal I made
                continue;
            }
            
            else if (choice == 4) // Searches for a key word and the articles associated
            {
                System.out.print("Enter the keyword to search: ");
                String searchKeyword = input.next();

                TreeNode<String> resultNode = bst.searchKeyword(searchKeyword); // uses the searchKeyword Keyword
                // to search for all the articles containing that key word 
                // with the new function I made which returns null rather than the parent 
                // in the original search function
            
                if (resultNode == null)  // if none is found
                {
                    System.out.println("Keyword not found.");
                    System.out.println();
                } 
                else // if found print 
                {
                    System.out.println("Keyword: " + resultNode.element); // displays the keyword
                    
                    System.out.println("Articles w/ keyword:"); // articles associated with it
                    
                    for (Article article : resultNode.head)
                    {
                        System.out.println(article);
                    }
                }
            
                continue;
            }
            
        } while (choice != 5);

    }

    public static void readFileRecords(BinarySearchTree bst, String filename) {
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(filename));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            if (fileReader == null) {
                System.out.println("Error: file must be opened first!");
                break;
            }
            else {
                try {
                    String strId = fileReader.readLine();
                    if (strId == null) 
                    break;
                    
                    int id = Integer.parseInt(strId);
                    
                    String title = fileReader.readLine();
                    
                    String author = fileReader.readLine();
                    
                    int numKeys = Integer.parseInt(fileReader.readLine());

                    String keyword;
                    
                    Article art;
                    for (int i=0; i<numKeys; i++) {
                        keyword = fileReader.readLine();
                        art = new Article(id, title, author);
                        bst.insert(keyword, art);
                    }

                    fileReader.readLine();
                }

                catch (NumberFormatException e) {
                    e.printStackTrace();
                    break;
                }
                catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }

        }

        // free up resources
        if (fileReader != null) {
            try {
                fileReader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class BinarySearchTree <E extends Comparable<E>> {
    protected TreeNode<E> root;
    protected int size;

    public TreeNode<E> search(E element) {

        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                parent = current;
                current = current.leftC;
            }
            else if (element.compareTo(current.element) > 0) {
                parent = current;
                current = current.rightC;

            }
            else if (element.compareTo(current.element) == 0) {
                return current;
            }
        }

        return parent;
    }
    
    public TreeNode<E> searchKeyword(E element) { // search for keyword

        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                parent = current;
                current = current.leftC;
            }
            else if (element.compareTo(current.element) > 0) {
                parent = current;
                current = current.rightC;

            }
            else if (element.compareTo(current.element) == 0) {
                return current;
            }
        }

        return null; // only line that is changed from original
        // as i need it to return null in case that the keyword is not found
        // and not return the parent of the current
    }
    
    
    public void insert(E element, Article art) {
        if (root == null) {
            root = new TreeNode<>(element);
            root.head.addFirst(art);
            //System.out.printf("Inserting root %s %s\n", element, art);
        }
        else {
            TreeNode<E> parent = search(element);
            if (parent != null) {
                if (element.compareTo(parent.element) < 0) {
                    //System.out.printf("Inserting Left Child of %s:\n %s %s\n", parent.element, element, art);
                    parent.leftC = new TreeNode<>(element);
                    parent.leftC.head.addFirst(art);
                }
                else if (element.compareTo(parent.element) > 0) {
                    //System.out.printf("Inserting Right Child of %s:\n %s %s\n", parent.element, element, art);
                    parent.rightC = new TreeNode<>(element);
                    parent.rightC.head.addFirst(art);
                }
                else {
                    parent.head.addFirst(art);
                    //System.out.printf("Adding LinkedList node at %s:\n %s %s\n", parent.element, element, art);
                }
            }
        }
        size++;
    }

    public void inOrder() {
        System.out.println("\n====================================================");
        System.out.println("Running InOrder Traversal of the Binary Search tree:");
        inOrder(root, "", true);
    }

    protected void inOrder(TreeNode<E> root, String prefix, boolean isLeft) {
        if (root == null) return;
        inOrder(root.leftC, prefix + (isLeft ? "   " : "    "), true);
        if (root != null) {
            System.out.printf("%s %s %s\n", prefix, (isLeft ? "L── " : "R── "), root.element);
            for (Article node : root.head)
                System.out.print(node);
            System.out.println();
        }
        inOrder(root.rightC, prefix + (isLeft ? "   " : "    "), false);
    }
    
    public void InOrderKeyWordsOnly() { // the display used when chosen 
        System.out.println("\n====================================================");
        System.out.println("InOrder Traversal (Keywords Only):");
        
        InOrderKeyWordsOnly(root, "", true); // call the function to display
        System.out.println();
    }
    
    public void InOrderKeyWordsOnly(TreeNode<E> node, String prefix, boolean isLeft) {
        
        if (node == null) // if node empty, do not display
        return;
        
        InOrderKeyWordsOnly(node.leftC, prefix + (isLeft ? "   " : "   "), true);
        // prints the left child of the current node 
        
        System.out.println(prefix + (isLeft ? "L-- " : "R-- ") + node.element);
        // prints the current node
        
        InOrderKeyWordsOnly(node.rightC, prefix + (isLeft ? "   " : "   "), false);
        // traverses to the right subtree 
    }
    
    public void preOrderKeywordsOnly() { // the display used when chosen
        System.out.println("\n====================================================");
        System.out.println("PreOrder Traversal (Keywords Only):");
        
        preOrderKeywordsOnly(root, "", true);
        System.out.println();
    }
    
    public void preOrderKeywordsOnly(TreeNode<E> node, String prefix, boolean isLeft) {
        if (node == null)
        return;
        
        System.out.printf("%s%s%s\n", prefix, (isLeft ? "L-- " : "R-- "), node.element);
        // prints the current node
        
        preOrderKeywordsOnly(node.leftC, prefix + (isLeft ? "   " : "    "), true);
        // prints the left child of the current node 
        
        
        preOrderKeywordsOnly(node.rightC, prefix + (isLeft ? "   " : "    "), false);
        // traverses to the right subtree 
    }
}


    



class TreeNode<E> {
    protected E element;
    protected TreeNode<E> leftC;
    protected TreeNode<E> rightC;
    protected LinkedList<Article> head;

    public TreeNode(E e) {
        element = e;
        head = new LinkedList<Article>();
    }

}

class Article {
    private int id;
    private String title;
    private String author;

    public Article() { }
    public Article(int i, String t, String a) {
        id =i;
        title = t;
        author = a;
    }

    @Override
    public String toString() {
        return String.format("\t %d | %s | %s-->\n", id, title, author);
    }
}