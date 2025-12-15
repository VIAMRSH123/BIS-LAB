GREY_WOLF_OPTIMIZATION()

1. Initialize parameters:
      N ← number of wolves
      MaxIter ← maximum iterations
      a ← control parameter (2 → 0)

2. Initialize population:
      for i ← 1 to N do
            initialize wolf position Xi randomly
      end for

3. Evaluate fitness of all wolves

4. Identify hierarchy:
      α ← best wolf
      β ← second best wolf
      δ ← third best wolf
      ω ← remaining wolves

5. iter ← 1

6. while iter ≤ MaxIter do

7.      for each wolf Xi (ω wolves included) do

8.            generate random vectors r1, r2, r3 ∈ [0,1]

9.            compute coefficient vectors:
                   A = 2*a*r1 − a
                   C = 2*r2

10.           compute distances:
                   Dα = |C * Xα − Xi|
                   Dβ = |C * Xβ − Xi|
                   Dδ = |C * Xδ − Xi|

11.           update position:
                   X1 = Xα − A * Dα
                   X2 = Xβ − A * Dβ
                   X3 = Xδ − A * Dδ

12.           Xi ← (X1 + X2 + X3) / 3

13.     end for

14.     Evaluate fitness of all wolves
15.     Update α, β, δ (ω updated automatically)
16.     Decrease a
17.     iter ← iter + 1

18. end while

19. return Xα (best solution)

END GREY_WOLF_OPTIMIZATION
