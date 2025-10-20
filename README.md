# Small Java Files

## These are java projects I have done as a UTD student that showcase certian skills I have built over my Undergrad

## heapPerformance.java

## Explanation
This program measures and compares the performance and heap construction using two different methods:
1. Repeated insertion
2. Bottum-Up construction

This program tests both methods using three different input types:
1. Sorted input
2. Reverse-ordered input
3. Random input

### Key concepts
heap data structure
Insertion-based heap building
Build heap algorithm in O(n) complexity
Performance testing
Array manipulation
Recursive heapify and sift-up operations

### how to run

bash: 

compile:
javac heapPerformance.java

run: 
java heapPerformance

sample output:
Sorted Input - Insertion Time: 7.932 ms
Sorted Input - Build Heap Time: 0.561 ms
Reverse-Ordered Input - Insertion Time: 12.103 ms
Reverse-Ordered Input - Build Heap Time: 0.589 ms
Random Input - Insertion Time: 8.776 ms
Random Input - Build Heap Time: 0.505 ms
(times vary based on hardware)

this is my implementation of the file:
https://onlinegdb.com/z27r-s3YcK


## bstSearch.java :

## text file that contains:

ArticleID
ArticleTitle
ArticleAuthor
NumberOfKeywords
Keyword1
Keyword2
(this would be one article, then to list a different article, you would have one line of buffer to then write the next one

## Explanation

For each keyword, a new Article is inserted in to a tree.

when program is run, it prompts for 5 menu options.
InOrder Traversal with details: displays keywords and all associated articles
InOrder Traversal with Keywords: lists keywords alphabetically
PreOrder Traversal with keywords: lists keywords in Pre-order
Search by Keyword: Looks up a specific keyword and displays all related articles
END

## Key concepts
This is a generic BST implementation using Comparable<E>.
LinkedList aggregation in each node for multiple records per keyword
Recursive in-order and pre-order traversal
File I/O
Keyword Search returning linked records
OOP fundamentals

## How to run

### in bash:

compile:
javac bstSearch.java

run:
java bstSearch
(ensure that datafile.txt is in the same directory with given list of a sample input)

## Sample input

Welcome to Information Retrieval System

1. InOrder Traversal with Details
2. InOrder Traversal (Keywords Only)
3. PreOrder Traversal (Keywords Only)
4. Search for a Keyword
5. Exit

Enter a choice? 4
Enter the keyword to search: MachineLearning

Keyword: MachineLearning
Articles w/ keyword:
     105 | Deep Learning | John Smith -->
     209 | Neural Nets in Practice | Alice Doe -->

This is a link to my implementation of the file:
https://onlinegdb.com/FyXW3ok3BD
