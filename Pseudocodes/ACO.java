AntColonyOptimization():

    // 1. Define the Problem
    define objective_function(path)
    define distance_matrix or graph_structure

    // 2. Initialize Parameters
    set num_ants
    set max_iterations
    set alpha            // influence of pheromone
    set beta             // influence of visibility (heuristic)
    set evaporation_rate
    set pheromone_deposit_value

    // 3. Initialize Pheromone Levels
    for each edge in graph:
        pheromone[edge] = initial_small_value

    iteration = 0

    // 4. Main Optimization Loop
    while iteration < max_iterations:

        solutions = []     // store all ant paths
        solution_costs = []

        // 5. Construct Solutions Using Ants
        for each ant in num_ants:

            path = empty list
            current_node = choose_random_start()

            while not all nodes visited:
                // compute probabilities of next node
                for each neighbor:
                    probability = 
                        (pheromone[current_node, neighbor]^alpha) *
                        (visibility[current_node, neighbor]^beta)

                next_node = select_based_on_probability()
                add next_node to path
                move ant to next_node

            solutions.append(path)
            solution_costs.append( objective_function(path) )


        // 6. Update Pheromones (Evaporation + Deposit)
        for each edge in graph:
            pheromone[edge] = (1 - evaporation_rate) * pheromone[edge]

        for each ant's path in solutions:
            cost = objective_function(path)
            for each edge in this path:
                pheromone[edge] += pheromone_deposit_value / cost


        // 7. Track the Best Solution
        update global_best_path with the best ant’s path so far

        iteration = iteration + 1


    // 8. Return Best Solution Found
    return global_best_path
