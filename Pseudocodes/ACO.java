ANT_COLONY_OPTIMIZATION()

1. Initialize parameters:
      α  ← pheromone importance
      β  ← heuristic importance
      ρ  ← evaporation rate
      Q  ← pheromone constant
      m  ← number of ants
      MaxIter ← maximum iterations

2. Initialize pheromone on all edges:
      for each edge (i, j):
            τ[i][j] ← τ0

3. for t ← 1 to MaxIter do

4.      for k ← 1 to m do
5.            place ant k on a random city
6.            tabu_list ← {starting city}

7.            while not all cities visited do
8.                  select next city j using probability:
                       P(i → j) =
                       (τ[i][j]^α * η[i][j]^β) /
                       Σ (τ[i][l]^α * η[i][l]^β)

9.                  move ant k to city j
10.                 add j to tabu_list
11.           end while

12.           compute tour length Lk
13.     end for

14.     for each edge (i, j) do
15.           τ[i][j] ← (1 − ρ) * τ[i][j]     // evaporation
16.     end for

17.     for k ← 1 to m do
18.           for each edge (i, j) in ant k tour do
19.                 τ[i][j] ← τ[i][j] + (Q / Lk)
20.           end for
21.     end for

22.     update best tour and best distance
23. end for

24. return best tour and minimum distance

END ANT_COLONY_OPTIMIZATION
