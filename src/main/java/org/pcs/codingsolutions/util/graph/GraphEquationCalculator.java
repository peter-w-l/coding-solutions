package org.pcs.codingsolutions.util.graph;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Solution for:
 * <p>
 * You are given an array of variable pairs equations and an array of real numbers values, where
 * equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find
 * the answer for Cj / Dj = ?.
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero
 * and that there is no contradiction.
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 * <p>
 * Constraints:
 * <p>
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
@UtilityClass
public class GraphEquationCalculator {

    public double[] calculateEquation(List<List<String>> equations,
                                      double[] equationResults,
                                      List<List<String>> queries) {
        Map<String, Map<String, EquationResult>> biDirectionalGraph = new HashMap<>();
        for (int i = 0; i < equationResults.length; i++) {
            List<String> equation = equations.get(i);
            double result = equationResults[i];
            biDirectionalGraph.computeIfAbsent(equation.get(0), key -> new HashMap<>())
                    .put(equation.get(1), new EquationResult(result, false));
            biDirectionalGraph.computeIfAbsent(equation.get(1), key -> new HashMap<>())
                    .put(equation.get(0), new EquationResult(result, true));
        }

        double[] queriesResults = new double[queries.size()];
        for (int i = 0; i < queriesResults.length; i++) {
            List<String> query = queries.get(i);
            queriesResults[i] = calculateQueryResult(query, biDirectionalGraph);
        }

        return queriesResults;
    }

    private double calculateQueryResult(List<String> query,
                                        Map<String, Map<String, EquationResult>> biDirectionalGraph) {
        String variable1Name = query.get(0);
        String variable2Name = query.get(1);

        if (!biDirectionalGraph.containsKey(variable1Name) || !biDirectionalGraph.containsKey(variable2Name)) {
            return -1.0;
        }
        if (variable1Name.equals(variable2Name)) {
            return 1.0;
        }

        return getPathResult(variable1Name,
                variable2Name,
                new HashSet<>(),
                biDirectionalGraph);
    }

    private double getPathResult(String variable1Name,
                                 String variable2Name,
                                 Set<String> visited,
                                 Map<String, Map<String, EquationResult>> biDirectionalGraph) {
        visited.add(variable1Name);

        for (var currentVariableName : biDirectionalGraph.get(variable1Name).keySet()) {
            if (!visited.contains(currentVariableName)) {
                if (variable2Name.equals(currentVariableName)) {
                    return biDirectionalGraph.get(variable1Name).get(variable2Name).getNonReversedValue();
                }
                double result = getPathResult(currentVariableName, variable2Name, visited, biDirectionalGraph);
                if (result != -1.0) {
                    return biDirectionalGraph.get(variable1Name).get(currentVariableName).getNonReversedValue()
                            * result;
                }
            }
        }
        return -1.0;
    }

    private record EquationResult(double value, boolean reversed) {
        public double getNonReversedValue() {
            return reversed ? 1 / value : value;
        }
    }
}
