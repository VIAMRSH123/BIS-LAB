ParticleSwarmOptimization():

    // 1. Define the Objective Function
    define objective_function(x)

    // 2. Initialize Parameters
    set swarm_size
    set max_iterations
    set inertia_weight          // controls old velocity influence
    set cognitive_constant      // pull toward personal best
    set social_constant         // pull toward global best

    // 3. Initialize Swarm
    for each particle i in swarm:
        particle.position = random_position()
        particle.velocity = random_velocity()
        particle.pBest = particle.position   // personal best starts at initial position
        particle.pBest_fitness = objective_function(particle.position)

    // 4. Determine Initial Global Best
    gBest = particle with highest pBest_fitness

    iteration = 0

    // 5. Main Optimization Loop
    while iteration < max_iterations and not convergence_reached():

        for each particle in swarm:

            // 6. Evaluate Fitness
            current_fitness = objective_function(particle.position)

            // 7. Update Personal Best (pBest)
            if current_fitness > particle.pBest_fitness:
                particle.pBest = particle.position
                particle.pBest_fitness = current_fitness

        // 8. Update Global Best (gBest)
        gBest = particle with highest pBest_fitness

        // 9. Update Velocity and Position of Each Particle
        for each particle in swarm:

            r1 = random value between 0 and 1
            r2 = random value between 0 and 1

            // velocity update
            particle.velocity =
                inertia_weight * particle.velocity +
                cognitive_constant * r1 * (particle.pBest - particle.position) +
                social_constant * r2 * (gBest.position - particle.position)

            // position update
            particle.position = particle.position + particle.velocity

        iteration = iteration + 1

    // 10. Return the Best Solution Found
    return gBest
