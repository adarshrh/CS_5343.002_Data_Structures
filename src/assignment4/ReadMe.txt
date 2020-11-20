/**
 * Name: Adarsh Raghupati Hegde
 * NetId: axh190002
 */

####Implementation of DFS and BFS in a graph

###### Steps to run the code in IntelliJ IDE
* Create an empty java project
* Unzip the source code files and paste it under the location "Java Project Name"/src folder
* Open the assignment4.GraphTraverse.java and run the program

###### Steps to run the code via command line
* Unzip the source code files
* Run the following command from unzipped location to compile
javac <path of unzipped folder location>/*.java
* Run following command to execute the code
java <path of unzipped folder location>/assignment4.GraphTraverse

###### Sample test run
Nodes are:
0 1 2 3 4 5 6 7 8 9 10 11 12
Edges: Undirected edges between the the vertices (u,v)
(1,0)
(2,0)
(2,1)
(3,1)
(4,3)
(5,1)
(5,3)
(5,4)
(6,2)
(6,5)
(7,0)
(8,7)
(9,7)
(9,8)
(10,6)
(10,9)
(11,8)
(11,10)
(12,4)
(12,5)
(12,6)
(12,10)
====================================================
DFS Traversal:
0
1
2
6
5
3
4
12
10
9
7
8
11
====================================================
BFS Traversal
0
1
2
7
3
5
6
8
9
4
12
10
11
