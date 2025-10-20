# Small Java Files

## These are java projects I have done as a UTD student that showcase certian skills I have built over my Undergrad



### bstSearch.java :
##### need
## text file that contains:
<ArticleID>
<ArticleTitle>
<ArticleAuthor>
<NumberOfKeywords>
<Keyword1>
<Keyword2>

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
