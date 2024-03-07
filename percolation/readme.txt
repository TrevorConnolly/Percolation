/* *****************************************************************************
 *  Operating system:
 *  [ examples are "OS X Ventura 13.5", "Windows 11", and "Ubuntu 22.04" ]
 *  Mac OS
 *  Compiler:
 *  [ an example is "Temurin 11.0.20" ]
 *   Temurin 11.0.20
 *  Text editor / IDE:
 *  [ an example is "IntelliJ 2023.2" ]
 *  IntelliJ
 *  Have you taken (part of) this course before:
 *  Have you taken (part of) the Coursera course Algorithms, Part I or II:
 *
 *  Hours to complete assignment (optional):
 *
 **************************************************************************** */

Programming Assignment 1: Percolation


/* *****************************************************************************
 *  Describe the data structures (i.e., instance variables) you used to
 *  implement the Percolation API.
 **************************************************************************** */

I used an instance double boolean array to store the grid of sites, an instance integer variable to store
the max row or column vlaue, an instance weighted quick union data type to help in performing the union
and several other operations, a tracker instance variable that is used to keep track of the number
of open sites, and two integer instance varibles representing the virtual top and virtual bottom sites.

/* *****************************************************************************
 *  Briefly describe the algorithms you used to implement each method in
 *  the Percolation API.
 **************************************************************************** */
open(): I used the weightedquickunion algorithm to union sites that are opened near the site that is being
opened in this method.
isOpen(): I checked if the site in the double boolean array was true or false and would return that value.
isFull(): I checked if the given site has the same parent value as the virtual top parent value which I can use
as a result of using the weightedquickunion algorithm.
numberOfOpenSites(): I used a tracker instance variable that incremented each time the open method opened
a new site.
percolates(): As a result of using weightedquickunion, I was able to check if the parent value of the bottom
virtual site equals the parent value of the top virtual site to thus see if it percolates.

/* *****************************************************************************
 *  First, implement Percolation using QuickFindUF.
 *  What is the largest values of n that PercolationStats can handle in
 *  less than one minute on your computer when performing T = 100 trials?
 *   The largest n value is 1030.
 *  Fill in the table below to show the values of n that you used and the
 *  corresponding running times. Use at least 5 different values of n.
 **************************************************************************** */

 T = 100

 n          time (seconds)
--------------------------
200   .5
1200   94.5
800    26.5
1000   53.264
1050   62.9

/* *****************************************************************************
 *  Describe the strategy you used for selecting the values of n.
 **************************************************************************** */

I guessed and checked using various values of n. If the time was below 60 seconds
I would increase the n value and check again however if the time was above 60
seconds I would decrease the n value.

/* *****************************************************************************
 *  Next, implement Percolation using WeightedQuickUnionUF.
 *  What is the largest values of n that PercolationStats can handle in
 *  less than one minute on your computer when performing T = 100 trials?
 * The largest value of n is 2049.
 *  Fill in the table below to show the values of n that you used and the
 *  corresponding running times. Use at least 5 different values of n.
 **************************************************************************** */

 T = 100

 n          time (seconds)
--------------------------
1000       4.7
1500      12.267
2000      30.1
2500      54.138
2800      72.1


/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */





/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */




/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */
