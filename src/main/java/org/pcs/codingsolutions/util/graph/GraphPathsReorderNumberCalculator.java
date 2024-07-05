package org.pcs.codingsolutions.util.graph;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for:
 * <p>
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between
 * two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads
 * in one direction because they are too narrow.
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * It's guaranteed that each city can reach city 0 after reorder.
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 5 * 104
 * connections.length == n - 1
 * connections[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 */
@UtilityClass
public class GraphPathsReorderNumberCalculator {
    public int getMinPathReorderNumber(int numberOfCities, int[][] pathsBetweenCities) {
        List<List<GraphEdge>> bidirectionalGraph = new ArrayList<>();
        for (int i = 0; i < numberOfCities; i++) {
            bidirectionalGraph.add(new ArrayList<>());
        }

        for(int[] path: pathsBetweenCities) {
            bidirectionalGraph.get(path[1]).add(GraphEdge.builder().nodeValue(path[0]).reversedPath(false).build());
            bidirectionalGraph.get(path[0]).add(GraphEdge.builder().nodeValue(path[1]).reversedPath(true).build());
        }
        boolean[] visitedCities = new boolean[numberOfCities];
        return getPathsChangesForNavigatingToCity(0, visitedCities, bidirectionalGraph);
    }

    private int getPathsChangesForNavigatingToCity(int cityNumber,
                                                   boolean[] visitedCities,
                                                   List<List<GraphEdge>> bidirectionalGraph) {
        visitedCities[cityNumber] = true;
        int numberOfChangesForCurrentPath = 0;
        for (GraphEdge cityPath : bidirectionalGraph.get(cityNumber)) {
            if (!visitedCities[cityPath.getNodeValue()]) {
                numberOfChangesForCurrentPath += getPathsChangesForNavigatingToCity(cityPath.getNodeValue(),
                        visitedCities,
                        bidirectionalGraph);
                if (cityPath.isReversedPath()) { // navigation should be TO the city with cityNumber and not FROM
                    numberOfChangesForCurrentPath++;
                }
            }
        }
        return numberOfChangesForCurrentPath;
    }

    @Builder
    @Value
    private class GraphEdge {
        int nodeValue;
        boolean reversedPath;
    }
}
