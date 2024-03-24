# Color the graph

Use the fewest possible colors, to colour the vertices of the graph such that no two adjecent vertices are the same color.

## Problem Statment

Graph coloring involves finding a way to color the vertices of the graph

Implment a function that finds a way of coloring a graph so that no two adjecent vertices are colored using the same color.
Try using minimum no of colors as possible.

## Input

The input is an unidirected graph with no colors assigned.

### Sample Input

```
graph{0 -- 1,
0 -- 2,
1 -- 2, 
1 -- 3, 
2 -- 3,
3 -- 4 }
```

### Output

The output is a graph with all of its vertices coloured in the correct way, using the min no of colours possible.

#### Output Sample

```
vertex 0, color 0
vertex 1, color 1
vertex 2, color 2
vertex 3, color 0
vertex 4, color 1
```
