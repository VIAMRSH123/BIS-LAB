# Daily Commit Backlog

A queue of real work for this repo. A scheduled agent takes the **top unchecked item**, does it,
verifies it, and commits. This repo is **submitted coursework (Biologically Inspired Systems) and a
public portfolio**, so the goal is legibility — and every change must be additive.

## Rules

1. **One item per run.** Finish it or leave it uncommitted.
2. **ALLOWED:** READMEs (top-level, per-lab, Pseudocodes), `.gitignore`, `requirements.txt`,
   dataset/licence notes, removing clearly accidental junk (`.DS_Store`, `.ipynb_checkpoints/`).
3. **FORBIDDEN:** editing any lab solution, changing an algorithm or its output, re-running
   notebooks so stored outputs change, reformatting `.ipynb`/`.java` source, renaming submitted files.
   If a lab looks wrong, record it under "Observations" — do not fix it.
4. **Verify:** no executable/notebook file changed (`git diff --stat` shows only docs/config), and
   every command a README tells a reader to run was actually run.
5. Stage named paths only; never `git add -A`. Conventional commit messages. Tick the item and
   append to the Log in the same commit.
6. If nothing can be done honestly, make no commit.

## Repo facts (verified 2026-11-11)

- No README, no requirements, no .gitignore. Colab-created notebooks (Colab badge in each).
- Lab-1 `BIS.ipynb`: genetic algorithm maximising x² on 5-bit chromosomes (pop 4, roulette selection,
  one-point crossover 0.8, mutation 0.1, 10 generations). No stored outputs.
- Lab-2 `BisLab2.ipynb`: "Gene Expression" — same GA loop with a decode/express step, maximising
  x³ − 4x² + 2x + 7·sin(x), 2 generations. Has stored output.
- Lab-3 `PSO.ipynb`: particle swarm optimisation maximising profit −0.5x² + 20x − 30 (workforce size);
  10 particles, 20 iterations. No stored outputs; optimum is x = 20, profit 170.
- Lab-4 `ACO.ipynb`: ant colony optimisation on a 5-city TSP; stored best tour `[0,1,4,2,3,0]`, length 13.
- Lab-5 `Cuckoo.ipynb`: cuckoo search on a 5-item 0/1 knapsack (capacity 50).
- Lab-6 `GWO.ipynb`: grey wolf optimizer on the 5-D sphere function; stored output includes a
  convergence plot.
- Lab-7 `PCA.ipynb`: **Parallel Cellular Algorithm** (not principal component analysis) minimising
  (x−2)² on a 10×10 wrap-around grid.
- `Pseudocodes/{PSO,ACO,GWO}.java`: plain-text pseudocode with a `.java` extension — not compilable Java.
- Dependencies seen in code: `random`, `math`, `numpy`, `matplotlib` (GWO plot only).

## Queue

- [ ] **B1 — Top-level `README.md`.** Table of the 7 labs: algorithm, problem solved, notebook link
      (relative + the existing Colab badge links), what the stored output shows, plus the Pseudocodes
      folder and licence. Use only facts in "Repo facts"; do not invent course codes, semester or marks.
- [ ] **B2 — `requirements.txt`** (`numpy`, `matplotlib`, `notebook`/`jupyter`) after installing them in
      a clean venv and running every notebook's code cells in order to confirm nothing else is imported.
      Add a "How to run" section to the README (Colab or local) once this exists.
- [ ] **B3 — `Pseudocodes/README.md`** explaining the three files are algorithm pseudocode (not Java),
      mapping each to its notebook (PSO→Lab-3, ACO→Lab-4, GWO→Lab-6), and noting GA/Cuckoo/PCA have none.
- [ ] **B4 — `.gitignore`** (`.DS_Store`, `.ipynb_checkpoints/`, `__pycache__/`, `.venv/`, `.idea/`,
      `.vscode/`). No such junk is tracked today, so this is preventive only.
- [ ] **B5 — Per-lab notes** (a short README in each `Lab-N/`): the objective function, parameters as
      written in the notebook, expected result, and the fact that runs are stochastic (no seed set),
      so numbers differ between runs. Only after B1–B3.

## Observations — for VB to decide (do NOT fix silently; graded work)

- **Cuckoo.ipynb stored output is internally inconsistent.** It reports `Best Fitness Value: 200` but
  selects items `[0,3,4]` with total weight 100 and value 360, which exceeds capacity W = 50. Cause in
  code: `best_cuckoo` is a view into `cuckoos` (later mutated in place) and the "keep better" loop is a
  no-op (`cuckoos[i] = cuckoos[i]`). The README should describe this honestly if it mentions results.
- **Cuckoo.ipynb and PCA.ipynb** each have a title line ("Knapsack Solved By Cuckoo Algorithm",
  "PARALLEL CELLULAR ALGORITHM") stored in a *code* cell, so "Run all" fails with a SyntaxError
  before the real code. Cell type should be markdown. Verified by extracting code cells.
- **GWO.ipynb** has an empty code cell after the badge cell; harmless.
- **Lab-7 file name `PCA.ipynb`** is easily misread as Principal Component Analysis; renaming is a VB call.
- Lab-1 and Lab-3 have no stored outputs (Lab-3 would converge to x = 20, profit 170 on re-run).
- LICENSE is MIT, copyright "Buyyani" (2025) — differs from the account name; VB to confirm intended.

## Log

2026-11-11 - audit - docs: add COMMIT_BACKLOG.md with verified audit of BIS-LAB
